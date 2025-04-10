package com.studies;

public class OrderItem {

    private String description;
    private double unitValue;
    private int quantity;

    public OrderItem(String description, double unitValue, int quantity) {
        this.description = description;
        this.unitValue = unitValue;
        this.quantity = quantity;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
