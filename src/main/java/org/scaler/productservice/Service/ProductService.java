package org.scaler.productservice.Service;

import org.scaler.productservice.Models.Product;

public interface ProductService {
    Product getProductById(long id);
    Product updateProduct(long id);
    Product deleteProduct(long id);
    Product createProduct(Product p);
}
