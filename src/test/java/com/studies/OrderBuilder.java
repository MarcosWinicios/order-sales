package com.studies;

import com.studies.discount.CalculatorDiscountBrand;
import com.studies.discount.CalculatorDiscountFirstBrand;
import com.studies.discount.CalculatorDiscountSecondBrand;
import com.studies.discount.CalculatorDiscountThirdBrand;
import com.studies.discount.WithoutDiscount;

public class OrderBuilder {

    private Order instance;

    public OrderBuilder() {

        CalculatorDiscountBrand calculatorDiscountBrand =
                new CalculatorDiscountThirdBrand(
                        new CalculatorDiscountSecondBrand(
                                new CalculatorDiscountFirstBrand(
                                        new WithoutDiscount(null)
                                )
                        )
                );

        this.instance = new Order(calculatorDiscountBrand);
    }

    public OrderBuilder withItem(double unitValue, int quantity) {
        this.instance.addItem(new OrderItem("Gerado", unitValue, quantity));
        return this;
    }

    public Order build() {
        return this.instance;
    }
}
