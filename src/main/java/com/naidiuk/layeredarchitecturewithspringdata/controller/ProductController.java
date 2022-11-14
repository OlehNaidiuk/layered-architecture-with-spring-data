package com.naidiuk.layeredarchitecturewithspringdata.controller;

import com.naidiuk.layeredarchitecturewithspringdata.dto.ProductDto;
import com.naidiuk.layeredarchitecturewithspringdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductDto productDto) {
        ProductDto updatedProduct = productService.update(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }
    
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> delete(@PathVariable Long productId) {
        ProductDto deletedProduct = productService.deleteById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedProduct);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductDto> products = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findById(@PathVariable Long productId) {
        ProductDto foundProduct = productService.findById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(foundProduct);
    }
    
    @GetMapping("/expired")
    public ResponseEntity<?> findExpired() {
        List<ProductDto> expiredProducts = productService.findExpired();
        return ResponseEntity.status(HttpStatus.OK).body(expiredProducts);
    }
    
    @GetMapping("/cheaper-than")
    public ResponseEntity<?> findCheaperThan(@RequestParam BigDecimal maxPrice) {
        List<ProductDto> cheaperProductsThanMaxPrice = productService.findCheaperThan(maxPrice);
        return ResponseEntity.status(HttpStatus.OK).body(cheaperProductsThanMaxPrice);
    }

    @GetMapping("/shelf-life")
    public ResponseEntity<?> findByShelfLife(@RequestParam int years) {
        List<ProductDto> expiredProducts = productService.findByShelfLife(years);
        return ResponseEntity.status(HttpStatus.OK).body(expiredProducts);
    }
}
