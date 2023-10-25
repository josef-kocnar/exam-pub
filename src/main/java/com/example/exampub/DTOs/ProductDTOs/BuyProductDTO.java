package com.example.exampub.DTOs.ProductDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BuyProductDTO {
    private Long userId;
    private Long productId;
    private Double price;
}
