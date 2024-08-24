//package org.scaler.productservice.Controller;
//
//import org.junit.jupiter.api.Test;
//import org.scaler.productservice.Exceptions.ProductNotFound;
//import org.scaler.productservice.Models.Product;
//import org.scaler.productservice.Service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest//importing and using the spring context
//class ProductControllerTest {
//
//    @Autowired
//    private ProductController productController;
//
//
//    @MockBean// annotation for faking this
//    private ProductService productService;
//
//    @Test
//    void TestGetProductById() throws ProductNotFound {
//
//        Product p = new Product();
//
//        when(productService.getProductById(1L)).thenReturn(p);
//
//        ResponseEntity<Product> ExpectedResponseEntity = new ResponseEntity<>(p, HttpStatus.OK);//expectation
//
//        ResponseEntity<Product> ActualResponse = productController.getProductById(1L, "");
//
//        assertEquals(ExpectedResponseEntity, ActualResponse);
//
//        /*
//        If you want to use exceptions, you have to import assertj library from
//        maven repo.
//
//        //error returned abc()
//        assertThrows(RuntimeException.class, ()->abc());// if you want to make the method as excutable, using lamba expression "()->"
//    }
//
//    int abc() {
//       throw new RuntimeException();
//
//    }
//         */
//
//}
//
//    @Test
//    void TestGetProductByIdError() throws ProductNotFound {
//
//        ProductNotFound productNotFound = new ProductNotFound("Product not found..");
//
//        when(productService.getProductById(1L)).thenThrow(productNotFound);
//
//
//        assertThrows(ProductNotFound.class,()->productController.getProductById(1L,""));
//    }
//    @Test
//    void TestGetAllProducts() {
//
//
//        Product p1 = new Product();
//        Product p2 = new Product();
//        Product p3 = new Product();
//
//        ArrayList<Product> products = new ArrayList<>();
//
//        products.add(p1);
//        products.add(p2);
//        products.add(p3);
//
//
//
//        Product[] p = new Product[3];
//        for(int i=0;i<3;i++){
//            p[i]= products.get(i);
//        }
//
//        when(productService.getAllProducts()).thenReturn(p);
//        List<Product> actualProducts =  productController.getAllProducts();
//        assertEquals(products, actualProducts);
//
//    }
//
//}
