package org.scaler.productservice.Service;

import org.scaler.productservice.Models.Category;
import org.scaler.productservice.Models.Product;
import org.scaler.productservice.dtos.FakeStoreResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    //We have to create a API to the fakestore to get the data
    //For creating a API, we need restTemplate
    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) {
        FakeStoreResponseDto fdto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);

        if(fdto == null){
            return null;
        }
        //if response is there, convert the response into product
        return ConvertFakeStroeDtoToProduct(fdto);



    }
    public Product ConvertFakeStroeDtoToProduct(FakeStoreResponseDto fdto){
        Product p = new Product();
        p.setId(fdto.getId());
        p.setDesc(fdto.getDesc());
        p.setTitle(fdto.getTitle());
        p.setPrice(fdto.getPrice());
        p.setImage(fdto.getImage());
     //creating obj of category to store it
        Category c = new Category();

        c.setTitle(fdto.getCategory());

        p.setCategory(c);

        return p;

    }

    @Override
    public Product updateProduct(long id) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product p) {
        return null;
    }
}
