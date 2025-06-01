package com.studies;

import com.studies.discount.CalculatorDiscountBrand;
import com.studies.exceptions.InvalidItemQuantity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<OrderItem> items =  new ArrayList<>();
    
    
    private CalculatorDiscountBrand calculatorDiscountBrand;

    public Order(CalculatorDiscountBrand calculatorDiscountBrand) {
        this.calculatorDiscountBrand = calculatorDiscountBrand;
    }

    public void addItem(OrderItem item) {
        validateItemQuantity(item);

        items.add(item);
    }

    public void validateItemQuantity(OrderItem item) {
        if(item.getQuantity() < 1) {
            throw new InvalidItemQuantity();
        }
    }

    public OrderSummary summary(){
        double totalValue = this.items.stream()
                .mapToDouble(item -> item.getUnitValue() * item.getQuantity())
                .sum();

        double discount = this.calculatorDiscountBrand.discount(totalValue);

        return new OrderSummary(totalValue, discount);
    }

}
