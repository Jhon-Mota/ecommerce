package com.ecommerce.controllers;

import com.ecommerce.Dtos.ProductDto;
import com.ecommerce.models.Product;
import com.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<String> registerProduct(@RequestBody @Valid ProductDto dto) {
        service.registerProduct(dto);
        return ResponseEntity.ok().body("Your product has been registered.");
    }

    @GetMapping("/{name}")
    private ResponseEntity<Product> findProducts(@PathVariable String name) {
        Product product = service.findByname(name);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listAllProducts(){
        List<Product> products = service.listAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{name}")
    public ResponseEntity<HttpStatus> updateProduct(@PathVariable String name, @RequestBody ProductDto dto) {
        service.updateProduct(name, dto);
        return ResponseEntity.accepted().build();
    }

}
