package com.ecommerce.controllers;

import com.ecommerce.Dtos.ProductDto;
import com.ecommerce.models.Product;
import com.ecommerce.services.ProductService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

  @Mock
  ProductService service;

  @InjectMocks
  ProductController controller;

  @Nested
  class ListAllProducts {

    @Test
    void shouldReturnOk() {
      // Arrange - prepare all mocks (or datas).
      service.registerProduct(new ProductDto("Samsung Tab S10 FE",
        BigDecimal.valueOf(2800.00), 1));

      // Act - execute the method to be tested.

     var response = controller.listAllProducts();

      // Assert - confirm that the test proceeds as expected.

      assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());

    }
  }

}
