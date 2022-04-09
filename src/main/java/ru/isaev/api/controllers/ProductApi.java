package ru.isaev.api.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isaev.api.model.ProductDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by i.isaev on 09.04.2022.
 */
@FeignClient(name = "product-api", url = "127.0.0.1:9966/products")
public interface ProductApi {

    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("productId") UUID productId);

    @PostMapping
    ResponseEntity<ProductDto> saveNewProduct(@RequestBody @Validated ProductDto productDto);

    @PutMapping("/{productId}")
    ResponseEntity<ProductDto> updateProductById(@PathVariable("productId") UUID productId,
                                                        @RequestBody @Validated ProductDto productDto);

    @GetMapping
    List<ProductDto> getAll();
}

