package com.naidiuk.layeredarchitecturewithspringdata.service;

import com.naidiuk.layeredarchitecturewithspringdata.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto productDto);
    List<ProductDto> findAll();
    ProductDto deleteById(Long productId);
    ProductDto findById(Long productId);
    List<ProductDto> findByShelfLife(int years);
    List<ProductDto> findExpired();
    List<ProductDto> findCheaperThan(BigDecimal maxPrice);
}
