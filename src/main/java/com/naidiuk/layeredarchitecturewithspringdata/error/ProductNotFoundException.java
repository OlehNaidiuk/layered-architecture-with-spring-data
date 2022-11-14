package com.naidiuk.layeredarchitecturewithspringdata.error;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
