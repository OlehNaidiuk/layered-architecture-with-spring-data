package com.naidiuk.layeredarchitecturewithspringdata.mapper;

import com.naidiuk.layeredarchitecturewithspringdata.dto.ProductDto;
import com.naidiuk.layeredarchitecturewithspringdata.entity.Product;

public class ProductMapper {
    private ProductMapper() {
    }

    public static Product transformToDao(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .currency(productDto.getCurrency())
                .description(productDto.getDescription())
                .producingCountry(productDto.getProducingCountry())
                .manufacturedDate(productDto.getManufacturedDate())
                .expirationDate(productDto.getExpirationDate())
                .build();
    }

    public static ProductDto transformToDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .currency(product.getCurrency())
                .description(product.getDescription())
                .producingCountry(product.getProducingCountry())
                .manufacturedDate(product.getManufacturedDate())
                .expirationDate(product.getExpirationDate())
                .build();
    }
}
