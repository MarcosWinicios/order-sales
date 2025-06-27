package com.studies.service;

import com.studies.email.EmailNotifier;
import com.studies.model.Order;
import com.studies.repository.OrderRepository;
import com.studies.sms.SmsNotifier;

public class OrderService {
    
    private OrderRepository orderRepository;
    private EmailNotifier emailNotifier;
    private SmsNotifier smsNotifier;

    public OrderService(OrderRepository orderRepository, EmailNotifier emailNotifier, SmsNotifier smsNotifier) {
        this.orderRepository = orderRepository;
        this.emailNotifier = emailNotifier;
        this.smsNotifier = smsNotifier;
    }
    
    public double launch(Order order) {

        orderRepository.save(order);
        emailNotifier.send(order);
        smsNotifier.send(order);

        return order.getValue() * 0.1;
    }
}
