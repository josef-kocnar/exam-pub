package com.example.exampub.DTOs.OrderDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetAllOrdersDTO {
    private String product;
    private long amount;
    private double unitPrice;
    private double summaryPrice;
}
