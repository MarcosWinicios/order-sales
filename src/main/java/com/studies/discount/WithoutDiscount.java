package com.studies.discount;

public class WithoutDiscount extends CalculatorDiscountBrand{

    public WithoutDiscount(CalculatorDiscountBrand next) {
        super(next);
    }

    @Override
    protected double calculate(double totalValue) {
        return 0;
    }
}
