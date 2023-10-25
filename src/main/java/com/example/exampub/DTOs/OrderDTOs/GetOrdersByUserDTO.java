package com.example.exampub.DTOs.OrderDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetOrdersByUserDTO {
    private long userId;
    private String product;
    private double price;
}
