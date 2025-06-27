package com.studies.service;

import com.studies.model.Order;
import com.studies.repository.OrderRepository;

public class OrderService {
    
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public double launch(Order order) {

        orderRepository.save(order);

        return order.getValue() * 0.1;
    }
}
