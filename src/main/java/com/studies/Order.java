package com.studies;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<OrderItem> items =  new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public OrderSummary summary(){
        double totalValue = this.items.stream()
                .mapToDouble(item -> item.getUnitValue() * item.getQuantity())
                .sum();

        double discount = 0;

        if(totalValue > 300.0 && totalValue <= 800.0) {
            discount = totalValue * 0.04;
        }else if (totalValue > 800.0 && totalValue <= 1000.0) {
            discount = totalValue * 0.06;
        }else if (totalValue > 1000.0) {
            discount = totalValue * 0.08;
        }

        return new OrderSummary(totalValue, discount);
    }

}
