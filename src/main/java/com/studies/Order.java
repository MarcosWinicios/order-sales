package com.studies;

public class Order {

    private double totalValue;
    private double discount;

    public void addItem(OrderItem item) {
        totalValue = item.getUnitValue() * item.getQuantity();
    }

    public double getTotalValue() {
        return totalValue;
    }

    public double getDiscount() {
        return discount;
    }
}
