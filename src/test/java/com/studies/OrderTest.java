package com.studies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private OrderBuilder order;

    @Before
    public void setUp() {
        order = new OrderBuilder();
    }

    private void assertOrderSummary(double totalValue, double discount) {
        OrderSummary summary = order.build().summary();

//        assertEquals(totalValue, summary.getTotalValue(), 0.0001); //O terceiro argument é a precisão/margem de erro
//        assertEquals(discount, summary.getDiscount(), 0.0001);

        assertEquals(new OrderSummary(totalValue, discount), summary);

    }

    @Test
    public void shouldCalculateTotalValueAndDiscountToEmptyOrder() throws Exception{
        assertOrderSummary(0.0, 0.0);
    }

    @Test
    public void shouldCalculateItemWithoutDiscountSummary() throws Exception{
        order.withItem(5.0, 5);
        assertOrderSummary(25.0, 0.0);
    }

    @Test
    public void shouldCalculateSummaryForTwoItemsWithoutDiscount() throws Exception{
        order.withItem(3.0, 3)
                .withItem(7.0, 3);

        assertOrderSummary(30, 0.0);
    }

    /**
     * <b>1° Discount Brand:</b> if the order has more than 300.0, the discount is 4%<br><br>
     */
    @Test
    public void shouldApplyDiscountToFirstBrand() throws Exception{
//        order.addItem(new OrderItem("Creme", 20.0, 20));

        order.withItem(20.0, 20);
        assertOrderSummary(400.0, 16.0);
    }

    /**
     * <b>2° Discount Brand:</b> if the order has more than 800.0, the discount is 6%
     */
    @Test
    public void shouldApplyDiscountToSecondBrand() throws Exception {
        order.withItem(15.0, 30)
                .withItem(15.0, 30);

        assertOrderSummary(900.0, 54.0);
    }

    /**
     * <b>3° Discount Brand:</b> if the order has more than 1000.0, the discount is 8%
     */
    @Test
    public void shouldApplyDiscountToThirdBrand() throws Exception {
        order.withItem(15.0, 30)
                .withItem(15.0, 30)
                .withItem(10.0, 30);

        assertOrderSummary(1200.0, 96.0);
    }


}
