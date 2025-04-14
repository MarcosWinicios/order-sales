package com.studies;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private double discount = 0;
    List<OrderItem> items =  new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalValue() {
         return this.items.stream()
                .mapToDouble(item -> item.getUnitValue() * item.getQuantity())
                .sum();
    }

    public double getDiscount() {
        return discount;
    }
}
