package com.example.exampub.DTOs.UserDTOs;

import com.example.exampub.models.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GetUserByIdDTO {
    private long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private double pocket;
    private List<Order> orders;
}
