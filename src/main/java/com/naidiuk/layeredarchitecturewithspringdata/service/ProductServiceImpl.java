package com.naidiuk.layeredarchitecturewithspringdata.service;

import com.naidiuk.layeredarchitecturewithspringdata.dto.ProductDto;
import com.naidiuk.layeredarchitecturewithspringdata.entity.Product;
import com.naidiuk.layeredarchitecturewithspringdata.error.ProductNotFoundException;
import com.naidiuk.layeredarchitecturewithspringdata.mapper.ProductMapper;
import com.naidiuk.layeredarchitecturewithspringdata.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = ProductMapper.transformToDao(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.transformToDto(savedProduct);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return save(productDto);
    }

    @Override
    public List<ProductDto> findAll() {
        Iterable<Product> iterableProducts = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        iterableProducts.forEach(products::add);
        return products.stream()
                .map(ProductMapper::transformToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto deleteById(Long productId) {
        ProductDto deletedProduct = findById(productId);
        productRepository.deleteById(productId);
        return deletedProduct;
    }

    @Override
    public ProductDto findById(Long productId) {
        Product product = productRepository.findById(productId)
                                        .orElseThrow(() ->
                                                new ProductNotFoundException(
                                                        String.format("Product with id=%d not found!", productId)));
        return ProductMapper.transformToDto(product);
    }

    @Override
    public List<ProductDto> findByShelfLife(int years) {
        List<Product> products = productRepository.findByShelfLife(years);
        return products.stream()
                .map(ProductMapper::transformToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findExpired() {
        List<Product> expiredProducts = productRepository.findExpired();
        return expiredProducts.stream()
                .map(ProductMapper::transformToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findCheaperThan(BigDecimal maxPrice) {
        List<Product> products = productRepository.findByPriceLessThan(maxPrice);
        return products.stream()
                .map(ProductMapper::transformToDto)
                .collect(Collectors.toList());
    }
}
