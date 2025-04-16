package com.studies;

import com.studies.discount.CalculatorDiscountBrand;
import com.studies.discount.CalculatorDiscountFirstBrand;
import com.studies.discount.CalculatorDiscountSecondBrand;
import com.studies.discount.CalculatorDiscountThirdBrand;
import com.studies.discount.WithoutDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        CalculatorDiscountBrand calculatorDiscountBrand =
                new CalculatorDiscountThirdBrand(
                        new CalculatorDiscountSecondBrand(
                                new CalculatorDiscountFirstBrand(
                                        new WithoutDiscount(null)
                                )
                        )
                );

        order = new Order(calculatorDiscountBrand);
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

    /**
     * <b>1° Discount Brand:</b> if the order has more than 300.0, the discount is 4%<br><br>
     */
    @Test
    public void shouldApplyDiscountToFirstBrand() throws Exception{
        order.addItem(new OrderItem("Creme", 20.0, 20));
        assertOrderSummary(400.0, 16.0);
    }

    /**
     * <b>2° Discount Brand:</b> if the order has more than 800.0, the discount is 6%
     */
    @Test
    public void shouldApplyDiscountToSecondBrand() throws Exception {
        order.addItem(new OrderItem("Shampoo", 15.0, 30));
        order.addItem(new OrderItem("Óleo", 15.0, 30));

        assertOrderSummary(900.0, 54.0);
    }

    /**
     * <b>3° Discount Brand:</b> if the order has more than 1000.0, the discount is 8%
     */
    @Test
    public void shouldApplyDiscountToThirdBrand() throws Exception {
        order.addItem(new OrderItem("Creme", 15.0, 30));
        order.addItem(new OrderItem("Shampoo", 15.0, 30));
        order.addItem(new OrderItem("Óleo", 10.0, 30));

        assertOrderSummary(1200.0, 96.0);
    }


}
