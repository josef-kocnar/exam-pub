package com.example.exampub.controllers;

import com.example.exampub.exceptions.Error;
import com.example.exampub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(userService.getUserById(id));
        } catch (Exception e) {
            Error error = new Error(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }

    }
}
