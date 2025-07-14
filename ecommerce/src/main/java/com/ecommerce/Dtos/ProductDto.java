package com.ecommerce.Dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDto(
        @NotBlank String name,
        @NotNull @DecimalMin("0.01") @Digits(integer = 10, fraction = 2) BigDecimal price,
        Integer amount
)
{}
