package org.scaler.productservice.Controller;

import org.scaler.productservice.Service.ProductService;
import org.scaler.productservice.Models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService ps;

    public ProductController(ProductService productService){
        this.ps = productService;

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return ps.getProductById(id);
        //homework - get all product
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return null;
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @PutMapping("/")//where I send all info to end user
    public Product updateProduct(@RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deletProduct(@PathVariable String id){
        return;
    }
}
