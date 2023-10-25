package com.example.exampub.DTOs.OrderDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetOrdersByProductDTO {
    private long userId;
    private long amount;
    private double price;
}
