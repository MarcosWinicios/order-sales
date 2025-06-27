package com.studies.service;

import com.studies.email.EmailNotifier;
import com.studies.model.Order;
import com.studies.repository.OrderRepository;
import com.studies.sms.SmsNotifier;

import java.util.List;

public class OrderService {
    
    private OrderRepository orderRepository;

    private List<OrderLaunchAction> actions;

    public OrderService(OrderRepository orderRepository, List<OrderLaunchAction> actions) {
        this.orderRepository = orderRepository;
        this.actions = actions;
    }
    
    public double launch(Order order) {
        double tax = order.getValue() * 0.1;

        orderRepository.save(order);

        actions.forEach(action -> action.execute(order));

        return tax;
    }
}
