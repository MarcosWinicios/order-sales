package com.studies.discount;

public abstract class CalculatorDiscountBrand {

    private CalculatorDiscountBrand next;

    public CalculatorDiscountBrand(CalculatorDiscountBrand next) {
        this.next = next;
    }

    public double discount(double totalValue) {

        double discount = this.calculate(totalValue);

        if(discount == -1) {
            return next.discount(totalValue);
        }
        return discount;
    }

    protected abstract double calculate(double totalValue);
}
