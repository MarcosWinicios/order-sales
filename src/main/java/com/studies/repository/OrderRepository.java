package com.studies.repository;

import com.studies.model.Order;

public class OrderRepository {

    public void save(Order order){
        System.out.println("Saving order: " + order.getValue() + " for client: " + order.getClient().getName() + " in the database.");
    }
}
