package com.studies.service;

import com.studies.email.EmailNotifier;
import com.studies.model.Order;
import com.studies.model.builder.OrderBuilder;
import com.studies.repository.OrderRepository;
import com.studies.sms.SmsNotifier;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private EmailNotifier emailNotifier;

    @Mock
    private SmsNotifier smsNotifier;

    private Order order;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(orderRepository, emailNotifier, smsNotifier);

        order =  new OrderBuilder()
                .withValue(100.0)
                .to("João", "joao@joao.com", "9999-0000")
                .build();

    }

    @Test
    public void mustCalculateTax() throws Exception{
        double tax = orderService.launch(order);
        assertEquals(10.0, tax, 0.0001);
    }

    @Test
    public void mustSaveOrderInDatabase() throws Exception{
        orderService.launch(order);
        Mockito.verify(orderRepository).save(order);
    }

    @Test
    public void mustNotifyByemail() throws Exception{
        orderService.launch(order);
        Mockito.verify(emailNotifier).send(order);
    }

    @Test
    public void mustNotifyBySms() throws Exception {
        orderService.launch(order);
        Mockito.verify(smsNotifier).send(order);
    }
}
