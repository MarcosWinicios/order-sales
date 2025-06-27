package com.studies.service;

import com.studies.model.Order;
import com.studies.model.builder.OrderBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    @Test
    public void mustCalculateTax(){
        Order order =  new OrderBuilder()
                .withValue(100.0)
                .to("João", "joao@joao.com", "9999-0000")
                .build();

        OrderService orderService = new OrderService();
        double tax = orderService.launch(order);
        assertEquals(10.0, tax, 0.0001);
    }
}
