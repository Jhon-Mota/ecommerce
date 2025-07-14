package com.ecommerce.mapper;

import com.ecommerce.Dtos.ProductDto;
import com.ecommerce.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product dtoToModel(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setAmount(dto.amount());

        return product;
    };

}
