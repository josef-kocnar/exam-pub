package com.example.exampub.services;

import com.example.exampub.DTOs.UserDTOs.GetAllUsersDTO;
import com.example.exampub.models.User;
import com.example.exampub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<GetAllUsersDTO> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        List<GetAllUsersDTO> getAllUsersDTOS = new ArrayList<>();
        for (User user : users) {
            GetAllUsersDTO getAllUsersDTO = new GetAllUsersDTO(user.getId(), user.getName(), user.isActive(), user.isAdult(), user.getPocket());
            getAllUsersDTOS.add(getAllUsersDTO);
        }
        return getAllUsersDTOS;
    }


}
