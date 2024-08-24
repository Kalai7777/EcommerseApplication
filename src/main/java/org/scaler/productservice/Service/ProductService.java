package org.scaler.productservice.Service;

import org.scaler.productservice.Exceptions.ProductNotFound;
import org.scaler.productservice.Models.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFound;
    Product updateProduct(long id, Product p);
    Product deleteProduct(long id);
    Product createProduct(Product p);
    Product[] getAllProducts();
    Page<Product> getAllProducts(int PageNumber, int PageSize);
}
