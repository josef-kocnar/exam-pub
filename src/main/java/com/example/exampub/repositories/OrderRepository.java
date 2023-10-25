package com.example.exampub.repositories;

import com.example.exampub.DTOs.OrderDTOs.BuyProductDTO;
import com.example.exampub.models.Order;
import com.example.exampub.models.Product;
import com.example.exampub.models.User;
import com.example.exampub.security.CustomUserDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addNewOrder(Order order) {
        entityManager.merge(order);
    }
}
