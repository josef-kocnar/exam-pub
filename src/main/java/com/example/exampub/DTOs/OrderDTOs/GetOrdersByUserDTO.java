package com.example.exampub.DTOs.OrderDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetOrdersByUserDTO {
    private long productId;
    private String product;
    private double price;
}
