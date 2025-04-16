package com.studies.discount;

public class CalculatorDiscountSecondBrand extends  CalculatorDiscountBrand{

    public CalculatorDiscountSecondBrand(CalculatorDiscountBrand next) {
        super(next);
    }

    @Override
    protected double calculate(double totalValue) {

        if (totalValue > 800.0 && totalValue <= 1000.0) {
            return totalValue * 0.06;
        }

        return -1;
    }
}
