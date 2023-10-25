package com.example.exampub.repositories;

import com.example.exampub.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers() {
        Query query = entityManager.createNativeQuery("SELECT * FROM users", User.class);
        return query.getResultList();
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public User findByUsername(String username) {
        Query query = entityManager.createNativeQuery("SELECT * FROM users WHERE username = :username", User.class);
        query.setParameter("username", username);
        if(query.getResultList().isEmpty()){
            return null;
        } else {
            return (User) query.getResultList().get(0);
        }
    }

    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
