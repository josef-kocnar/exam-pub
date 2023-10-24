package com.example.exampub.repositories;

import com.example.exampub.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers() {
        Query query = entityManager.createNativeQuery("SELECT * FROM users", User.class);
        return query.getResultList();
    }
}
