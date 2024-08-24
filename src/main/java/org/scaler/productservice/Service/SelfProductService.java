package org.scaler.productservice.Service;

import org.scaler.productservice.Exceptions.ProductNotFound;
import org.scaler.productservice.Models.Category;
import org.scaler.productservice.Models.Product;
import org.scaler.productservice.Repo.CategoryRepo;
import org.scaler.productservice.Repo.ProductRepo;
import org.scaler.productservice.common.AuthCommon;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary // when ever we are sure that this is our main service, we can tag it as @Primary
@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;


    SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;

    }
    @Override
    public Product getProductById(long id) throws ProductNotFound {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFound("Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public Product updateProduct(long id, Product p) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product p) {
        // TODO: HANDLE EDGE CASES..

        // Before saving product we need to create category in db

        Category category = p.getCategory();
        if(category.getId()==null){
            Category savedCategory = categoryRepo.save(category);
            p.setCategory(savedCategory);
        }else{
            //we need to check if id exists...
        }
        Product saveProduct = productRepo.save(p);
        Optional<Category> optionalCategory = categoryRepo.findById(category.getId());
        if(optionalCategory.isEmpty()){
            throw new RuntimeException("Category is empty,.,");
        }
        saveProduct.setCategory(optionalCategory.get());
        return saveProduct;
    }

/*
    @Override
    public Product[] getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        Product[] products = new Product[allProducts.size()];
        allProducts.toArray(products);
        return products;
    }

 */

    @Override
    public Product[] getAllProducts() {
       return new Product[0];
    }

    @Override
    public Page<Product> getAllProducts(int PageNumber, int PageSize) {
//        Sort.by("price").ascending().and(Sort.by("title")).descending();
        return productRepo.findAll(PageRequest.of(PageNumber, PageSize,
                Sort.by("price").ascending()))  ;

    }
}
