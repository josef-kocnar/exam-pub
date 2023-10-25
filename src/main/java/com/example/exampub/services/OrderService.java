package com.example.exampub.services;

import com.example.exampub.DTOs.OrderDTOs.BuyProductDTO;
import com.example.exampub.models.Order;
import com.example.exampub.models.Product;
import com.example.exampub.models.User;
import com.example.exampub.repositories.OrderRepository;
import com.example.exampub.repositories.ProductRepository;
import com.example.exampub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    public void addNewOrder(BuyProductDTO buyProductDTO) throws Exception{
        if (buyProductDTO.getProductId() == null || buyProductDTO.getPrice() == null || buyProductDTO.getUserId() == null) {
            throw new Exception("All fields are required");
        }

        User user = userRepository.getUserById(buyProductDTO.getUserId());
        Product product = productRepository.getProductById(buyProductDTO.getProductId());
        System.out.println(user.isAdult());

        if (user == null) {
            throw new Exception("Invalid user ID");
        }
        if (product == null) {
            throw new Exception("Invalid product ID");
        }
        if (product.isForAdult() && !user.isAdult()) {
            throw new Exception("No alcohol will be served to minors!");
        }
        if (buyProductDTO.getPrice() > user.getPocket()) {
            throw new Exception("Insufficient funds");
        }

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setAmount((long) (buyProductDTO.getPrice() / product.getPrice()));
        order.setPrice(buyProductDTO.getPrice());
        orderRepository.addNewOrder(order);

        user.setPocket(user.getPocket()-order.getPrice());
        userRepository.updateUser(user);
    }
}
