package com.example.exampub.repositories;

import com.example.exampub.models.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addNewOrder(Order order) {
        entityManager.merge(order);
    }

    public List<Order> getAllOrders() {
        Query query = entityManager.createNativeQuery("SELECT * FROM orders", Order.class);
        return query.getResultList();
    }

    public List<Order> getOrdersByProduct(long productId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM orders WHERE product_id = :productId", Order.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    public List<Order> getOrdersByUser(long userId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM orders WHERE user_id = :userId", Order.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
