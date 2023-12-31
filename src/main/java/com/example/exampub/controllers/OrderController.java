package com.example.exampub.controllers;

import com.example.exampub.DTOs.ProductDTOs.BuyProductDTO;
import com.example.exampub.exceptions.Error;
import com.example.exampub.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/buy")
    public ResponseEntity buyProduct(@RequestBody BuyProductDTO buyProductDTO) {
        try {
            orderService.addNewOrder(buyProductDTO);
            return ResponseEntity.ok().body("Order was successful");
        } catch (Exception e) {
            Error error = new Error(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @GetMapping("/summary/all")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @GetMapping("/summary/product")
    public ResponseEntity getAllProductOrders() {
        return ResponseEntity.ok().body(orderService.getAllProductOrders());
    }

    @GetMapping("/summary/user")
    public ResponseEntity getAllUserOrders() {
        return ResponseEntity.ok().body(orderService.getAllUserOrders());
    }

}
