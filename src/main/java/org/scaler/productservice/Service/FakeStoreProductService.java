package org.scaler.productservice.Service;

import org.scaler.productservice.Exceptions.ProductNotFound;
import org.scaler.productservice.Models.Category;
import org.scaler.productservice.Models.Product;
import org.scaler.productservice.common.AuthCommon;
import org.scaler.productservice.dtos.FakeStoreRequestDTO;
import org.scaler.productservice.dtos.FakeStoreResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStore")
public class FakeStoreProductService implements ProductService{

    //We have to create a API to the fakestore to get the data
    //For creating a API, we need restTemplate
    private RestTemplate restTemplate;

    private RedisTemplate redisTemplate;

    private AuthCommon authCommon;

    public FakeStoreProductService(RestTemplate restTemplate,RedisTemplate redisTemplate, AuthCommon authCommon){
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
        this.authCommon = authCommon;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFound  {
        Product p = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCTS_"+id);
        try {
            authCommon.validate("");
        } catch(Exception e){
            System.out.println("called user service...");
        }

        if(p!=null){
            //Cache Hit...
            return p;
        }

        FakeStoreResponseDto fdto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);

        if(fdto == null){

            throw new ProductNotFound("productNotFound");
        }


        //if response is there, convert the response into product
        p = ConvertFakeStroeDtoToProduct(fdto);

        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCTS_"+id, p);

        return p;


    }
    public Product ConvertFakeStroeDtoToProduct(FakeStoreResponseDto fdto){
        Product p = new Product();
        p.setId(fdto.getId());
        p.setDescription(fdto.getDescription());
        p.setTitle(fdto.getTitle());
        p.setPrice(fdto.getPrice());
        p.setImage(fdto.getImage());
     //creating obj of category to store it
        Category c = new Category();

        c.setTitle(fdto.getCategory());

        p.setCategory(c);

        return p;

    }

    public FakeStoreRequestDTO ConvertProductToFakeStoreRequest(Product p){
        FakeStoreRequestDTO requestDTO = new FakeStoreRequestDTO();
        requestDTO.setCategory(p.getCategory().getTitle());
        requestDTO.setImage(p.getImage());
        requestDTO.setPrice(p.getPrice());
        requestDTO.setTitle(p.getTitle());
        requestDTO.setDesc(p.getDescription());

        return requestDTO;
    }


    @Override
    public Product updateProduct(long id, Product p) {
        FakeStoreRequestDTO requestDTO = ConvertProductToFakeStoreRequest(p);
        try {
            restTemplate.put("https://fakestoreapi.com/products/" + id, requestDTO);
        }catch (Exception e){
            System.out.println("Error occured");
        }
        return p;

    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product p) {
        FakeStoreRequestDTO fakeStoreRequestDto = ConvertProductToFakeStoreRequest(p);
        FakeStoreResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products/", fakeStoreRequestDto, FakeStoreResponseDto.class);
        if(response == null){
            throw new RuntimeException("product is null");
        }
        return ConvertFakeStroeDtoToProduct(response);
    }

    public Product[] getAllProducts(){
        FakeStoreResponseDto[] fdto = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreResponseDto[].class);

        Product[] products = new Product[fdto.length];
        for(int i=0; i<fdto.length; i++){
            products[i] = ConvertFakeStroeDtoToProduct(fdto[i]);
        }
        return products;
    }

    @Override
    public Page<Product> getAllProducts(int PageNumber, int PageSize) {
        return null;
    }
}
