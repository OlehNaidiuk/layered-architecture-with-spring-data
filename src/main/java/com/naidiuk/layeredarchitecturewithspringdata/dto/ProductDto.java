package com.naidiuk.layeredarchitecturewithspringdata.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.naidiuk.layeredarchitecturewithspringdata.entity.ProducingCountry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductDto {
    private Long productId;
    private String name;
    private BigDecimal price;
    private Currency currency;
    private String description;
    private ProducingCountry producingCountry;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate manufacturedDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;
}
