package com.example.exampub.DTOs.ProductDTOs;

import com.example.exampub.DTOs.OrderDTOs.GetOrdersByProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GetAllProductOrdersDTO {
    private long id;
    private String name;
    private List<GetOrdersByProductDTO> orders;
}
