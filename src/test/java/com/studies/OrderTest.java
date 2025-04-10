package com.studies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order();
    }

    private void assertOrderSummary(double totalValue, double discount) {
        assertEquals(totalValue, order.getTotalValue(), 0.0001); //O terceiro argument é a precisão/margem de erro
        assertEquals(discount, order.getDiscount(), 0.0001);
    }

    @Test
    public void shouldAllowAddingAnItemToTheOrder() throws Exception{
        order.addItem(new OrderItem("Sabonete", 3.0, 10));
    }

    @Test
    public void shouldCalculateTotalValueAndDiscountToEmptyOrder() throws Exception{
        assertOrderSummary(0.0, 0.0);
    }

    @Test
    public void shouldCalculateItemWithoutDiscountSummary() throws Exception{
        order.addItem(new OrderItem("Sabonete", 5.0, 5));
        assertOrderSummary(25.0, 0.0);
    }



}
