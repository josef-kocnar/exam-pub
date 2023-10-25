package com.example.exampub.repositories;

import com.example.exampub.models.Product;
import com.example.exampub.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Product> getAllProducts() {
        Query query = entityManager.createNativeQuery("SELECT * FROM products", Product.class);
        return query.getResultList();
    }

    public Product getProductById(long id) {
        return entityManager.find(Product.class, id);
    }
}
