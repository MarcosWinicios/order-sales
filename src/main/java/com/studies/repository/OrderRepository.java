package com.studies.repository;

import com.studies.model.Order;

public class OrderRepository {

    public void save(Order order){
        System.out.println("Saving order: " + order.getValue() + " for client: " + order.getClient().getName() + " in the database.");
    }

    public Order findByCode(Long code) {
        System.out.println("Finding order by code: " + code);
        // Simulate finding an order
        // In a real application, this would query the database

        return new Order();
    }
}
