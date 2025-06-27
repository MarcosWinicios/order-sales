package com.studies.service;

import com.studies.email.EmailNotifier;
import com.studies.exceptions.OrderStatuInvalidException;
import com.studies.model.Order;
import com.studies.model.OrderStatus;
import com.studies.model.builder.OrderBuilder;
import com.studies.repository.OrderRepository;
import com.studies.sms.SmsNotifier;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

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

        List<OrderLaunchAction> actions = List.of(emailNotifier, smsNotifier);

        orderService = new OrderService(orderRepository, actions);

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
        Mockito.verify(emailNotifier).execute(order);
    }

    @Test
    public void mustNotifyBySms() throws Exception {
        orderService.launch(order);
        Mockito.verify(smsNotifier).execute(order);
    }

    @Test
    public void mustToPayPendingOrder() throws Exception{
        Long orderCode = 135L;

        Order pendingOrder = new OrderBuilder()
                .withStatus(OrderStatus.PENDING)
                .build();

        Mockito.when(orderRepository.findByCode(orderCode))
                .thenReturn(pendingOrder);


        Order paidOrder = orderService.pay(orderCode);

        assertEquals(OrderStatus.PAID, paidOrder.getStatus());
    }

    @Test(expected = OrderStatuInvalidException.class)
    public void mustDenyPayment() throws Exception {
        Long orderCode = 135L;

        Order paidOrder = new OrderBuilder()
                .withStatus(OrderStatus.PAID)
                .build();

        Mockito.when(orderRepository.findByCode(orderCode))
                .thenReturn(paidOrder);

        orderService.pay(orderCode);
    }
}
