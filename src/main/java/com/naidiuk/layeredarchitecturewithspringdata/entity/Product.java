package com.naidiuk.layeredarchitecturewithspringdata.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private BigDecimal price;
    private Currency currency;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProducingCountry producingCountry;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate manufacturedDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;
}
