package com.example.exampub.DTOs.UserDTOs;

import com.example.exampub.DTOs.OrderDTOs.GetOrdersByUserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GetAllUserOrdersDTO {
    private long id;
    private String name;
    private List<GetOrdersByUserDTO> orders;
}
