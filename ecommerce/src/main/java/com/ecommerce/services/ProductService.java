package com.ecommerce.services;

import com.ecommerce.Dtos.ProductDto;
import com.ecommerce.Exceptions.ProductNotFoundException;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.models.Product;
import com.ecommerce.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository repository;

    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void registerProduct(ProductDto dto) {
        Product newProduct = mapper.dtoToModel(dto);
        repository.save(newProduct);
    }

    public Product findByname(String name) {
        return repository.findByName(name).orElseThrow(
                () -> new ProductNotFoundException("Product not found."));

    }

    public List<Product> listAllProducts(){
        return this.repository.findAll();
    }

    public void deleteByName(String name) {
        repository.deleteByName(name);
    }

    public void updateProduct(String name, ProductDto dto) {
        Product productEntity = repository.findByName(name).orElseThrow(
                () -> new ProductNotFoundException("Product not found."));

        Product updatedProduct = Product.builder()
                .name(dto.name() != null ? dto.name() : productEntity.getName())
                .price(dto.price() != null ? dto.price() : productEntity.getPrice())
                .amount(dto.amount() != null ? dto.amount() : productEntity.getAmount())
                .id(productEntity.getId())
                .build();

        repository.save(updatedProduct);

    }

}
