package com.example.exampub.DTOs.UserDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetAllUsersDTO {
    private long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private double pocket;
}
