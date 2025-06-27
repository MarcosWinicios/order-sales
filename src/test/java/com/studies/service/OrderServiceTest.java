package com.studies.service;

import com.studies.model.Order;
import com.studies.model.builder.OrderBuilder;
import com.studies.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    private OrderService orderService;

    @Before
    public void setUp() {
        OrderRepository repository = Mockito.mock(OrderRepository.class);
        orderService = new OrderService(repository);
    }

    @Test
    public void mustCalculateTax() throws Exception{
        Order order =  new OrderBuilder()
                .withValue(100.0)
                .to("João", "joao@joao.com", "9999-0000")
                .build();

        double tax = orderService.launch(order);
        assertEquals(10.0, tax, 0.0001);
    }

    @Test
    public void mustSaveOrderInDatabase() throws Exception{
        Order order =  new OrderBuilder()
                .withValue(100.0)
                .to("João", "joao@joao.com", "9999-0000")
                .build();

        orderService.launch(order);
    }
}
