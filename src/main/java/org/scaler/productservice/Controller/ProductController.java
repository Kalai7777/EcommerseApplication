package org.scaler.productservice.Controller;

import org.scaler.productservice.Exceptions.ProductNotFound;
import org.scaler.productservice.Service.ProductService;
import org.scaler.productservice.Models.Product;
import org.scaler.productservice.common.AuthCommon;
import org.scaler.productservice.dtos.Roles;
import org.scaler.productservice.dtos.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService ps;
    private AuthCommon authCommon;

    public ProductController(@Qualifier("FakeStore") ProductService productService, AuthCommon authCommon){
        this.ps = productService;
        this.authCommon = authCommon;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFound {
//        UserDto user = authCommon.validate(auth);
//
//        if (user != null){
//            for(Roles r : user.getRoles()){
//                if (r.getRoles() == "ADMIN"){
//
//                }
//            }
//        }
        Product p = ps.getProductById(id); // dependency..

        return new ResponseEntity<>(p, HttpStatus.OK);

//        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

//try{
//        } catch (ArithmeticException ae){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        } catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
    }


    @GetMapping("/")
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
//        Product[] products = ps.getAllProducts();
//
//        products[0].setTitle("abc");

        return ps.getAllProducts(pageNumber,pageSize);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        return ps.createProduct(product);
    }

    @PutMapping("/{id}")//where I send all info to end user
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return ps.updateProduct(id,product);
//        return "Hello";
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        return;
    }
}



























