package com.studies.discount;

public class CalculatorDiscountFirstBrand extends CalculatorDiscountBrand{

    public CalculatorDiscountFirstBrand(CalculatorDiscountBrand next) {
        super(next);
    }

    @Override
    protected double calculate(double totalValue) {
        if(totalValue > 300.0 && totalValue <= 800.0) {
            return totalValue * 0.04;
        }
        return -1;
    }
}
