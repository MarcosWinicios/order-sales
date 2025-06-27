package com.studies.service;

import com.studies.model.Order;

public class OrderService {
    public double launch(Order order) {
        return order.getValue() * 0.1;
    }
}
