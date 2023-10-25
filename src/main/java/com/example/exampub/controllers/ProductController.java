package com.example.exampub.controllers;

import com.example.exampub.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/drink-menu")
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
}
