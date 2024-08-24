package org.scaler.productservice;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.scaler.productservice.Controller.ProductController;
import org.scaler.productservice.Models.Category;
import org.scaler.productservice.Models.Product;
import org.scaler.productservice.Repo.CategoryRepo;
import org.scaler.productservice.Repo.ProductRepo;
import org.scaler.productservice.projection.ProductWithTitleAndDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest//context of spring boot application
class ProductServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    /* 1

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductController productController;

    @Test
    @Transactional//It is used when ever you have to use whole thing as transaction, like one thing fails everything should roll back
    public void testTc(){
        Optional<Category> optionalCategory = categoryRepo.findById(1L);
        Category category = optionalCategory.get();
        List<Product> products = category.getProducts();
        System.out.println("testing eager loading..");


        ProductWithTitleAndDescription p = productRepo.someRandomQuery(1L);

        System.out.println(p.getTitle());
        System.out.println(p.getDescription());

        ProductWithTitleAndDescription p2 = productRepo.someRandomQuery2(1L);

        System.out.println(p2.getTitle());
        System.out.println(p2.getDescription());


    }
     */

//    This is how sending an harcoded method not calling to actual method while testing
//    public  void testgetProductById(){
//        when(ps.getProductById(10)).thenReturn(new Product().setId(10));
//
//        productController.getProductById(10);
//
//    }

}
