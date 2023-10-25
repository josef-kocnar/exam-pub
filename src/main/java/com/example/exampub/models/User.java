package com.example.exampub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String role;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private double pocket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orders;
}
