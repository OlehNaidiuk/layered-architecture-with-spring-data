package com.naidiuk.layeredarchitecturewithspringdata.repository;

import com.naidiuk.layeredarchitecturewithspringdata.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value = "select p from Product p where p.expirationDate < CURRENT_DATE")
    List<Product> findExpired();
    List<Product> findByPriceLessThan(BigDecimal maxPrice);
    @Query(value = "select * from product where floor(datediff(expiration_date, manufactured_date)/365) = :years",
            nativeQuery = true)
    List<Product> findByShelfLife(int years);
}
