package com.example.exampub.services;

import com.example.exampub.DTOs.OrderDTOs.GetAllOrdersDTO;
import com.example.exampub.DTOs.OrderDTOs.GetOrdersByProductDTO;
import com.example.exampub.DTOs.OrderDTOs.GetOrdersByUserDTO;
import com.example.exampub.DTOs.ProductDTOs.BuyProductDTO;
import com.example.exampub.models.Order;
import com.example.exampub.models.Product;
import com.example.exampub.models.User;
import com.example.exampub.repositories.OrderRepository;
import com.example.exampub.repositories.ProductRepository;
import com.example.exampub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (buyProductDTO.getPrice() < product.getPrice() || buyProductDTO.getPrice() % product.getPrice() != 0) {
            throw new Exception("Incorrect price");
        }

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setName(product.getProductName());
        order.setAmount((long) (buyProductDTO.getPrice() / product.getPrice()));
        order.setPrice(buyProductDTO.getPrice());
        orderRepository.addNewOrder(order);

        user.setPocket(user.getPocket()-order.getPrice());
        userRepository.updateUser(user);
    }

    public List<GetAllOrdersDTO> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders();
        List<GetAllOrdersDTO> getAllOrdersDTOS = new ArrayList<>();
        HashMap<Long, Long> orderMap = new HashMap<>();

        for (Order order : orders) {
            long productId = order.getProduct().getId();
            if (orderMap.containsKey(productId)) {
                orderMap.put(productId, orderMap.get(productId)+1);
            } else {
                orderMap.put(productId, (long) 1);
            }
        }

        for(Map.Entry<Long, Long> entry : orderMap.entrySet()) {
            Product product = productRepository.getProductById(entry.getKey());
            GetAllOrdersDTO getAllOrdersDTO = new GetAllOrdersDTO(product.getProductName(),entry.getValue(), product.getPrice(), entry.getValue() * product.getPrice());
            getAllOrdersDTOS.add(getAllOrdersDTO);
        }

        return getAllOrdersDTOS;
    }

    public List<GetOrdersByProductDTO> getOrdersByProduct(long productId) throws Exception{
        Product product = productRepository.getProductById(productId);
        if (product == null) {
            throw new Exception("Invalid product ID");
        }

        List<Order> orders = orderRepository.getOrdersByProduct(productId);
        List<GetOrdersByProductDTO> getOrdersByProductDTOS = new ArrayList<>();
        HashMap<Long, Long> orderMap = new HashMap<>();

        for (Order order : orders) {
            long userId = order.getUser().getId();
            if (orderMap.containsKey(userId)) {
                orderMap.put(userId, orderMap.get(userId)+1);
            } else {
                orderMap.put(userId, (long) 1);
            }
        }

        for (Map.Entry<Long, Long> entry : orderMap.entrySet()) {
            User user = userRepository.getUserById(entry.getKey());
            GetOrdersByProductDTO getOrdersByProductDTO = new GetOrdersByProductDTO(user.getId(), entry.getValue(), product.getPrice() * entry.getValue());
            getOrdersByProductDTOS.add(getOrdersByProductDTO);
        }

        return getOrdersByProductDTOS;
    }

    public List<GetOrdersByUserDTO> getOrdersByUser(long userId) throws Exception{
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new Exception("Invalid user ID");
        }

        List<Order> orders = orderRepository.getOrdersByUser(userId);
        List<GetOrdersByUserDTO> getOrdersByUserDTOS = new ArrayList<>();
        HashMap<Long, Long> orderMap = new HashMap<>();

        for (Order order : orders) {
            long productId = order.getProduct().getId();
            if (orderMap.containsKey(productId)) {
                orderMap.put(productId, orderMap.get(productId)+1);
            } else {
                orderMap.put(productId, (long) 1);
            }
        }

        for(Map.Entry<Long, Long> entry : orderMap.entrySet()) {
            Product product = productRepository.getProductById(entry.getKey());
            GetOrdersByUserDTO getOrdersByUserDTO = new GetOrdersByUserDTO(userId, product.getProductName(), entry.getValue() * product.getPrice());
            getOrdersByUserDTOS.add(getOrdersByUserDTO);
        }

        return getOrdersByUserDTOS;
    }
}
