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
        OrderSummary summary = order.summary();

        assertEquals(totalValue, summary.getTotalValue(), 0.0001); //O terceiro argument é a precisão/margem de erro
        assertEquals(discount, summary.getDiscount(), 0.0001);
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

    @Test
    public void shouldCalculateSummaryForTwoItemsWithoutDiscount() throws Exception{
        order.addItem(new OrderItem("Sabonete", 3.0, 3));
        order.addItem(new OrderItem("Shampoo", 7.0, 3));
        assertOrderSummary(30, 0.0);
    }

    @Test
    public void shouldApplyDiscountToFirstBrand() throws Exception{
        order.addItem(new OrderItem("Creme", 20.0, 20));

        assertOrderSummary(400.0, 16.0);
    }


}
