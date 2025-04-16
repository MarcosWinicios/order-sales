package com.studies.discount;

public class CalculatorDiscountThirdBrand extends CalculatorDiscountBrand{


    public CalculatorDiscountThirdBrand(CalculatorDiscountBrand next) {
        super(next);
    }

    @Override
    protected double calculate(double totalValue) {

        if (totalValue > 1000.0) {
            return totalValue * 0.08;
        }
        return -1;
    }
}
