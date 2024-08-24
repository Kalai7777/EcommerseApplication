package org.scaler.productservice.Exceptions;

public class ProductNotFound extends Exception{
    public ProductNotFound(String productNotFound) {
        super(productNotFound);
    }
}
