package com.studies;

public class OrderSummary {

    private double totalValue;
    private double discount;

    public OrderSummary(double totalValue, double discount) {
        this.totalValue = totalValue;
        this.discount = discount;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * <b>1° Discount Brand:</b> if the order has more than 300.0, the discount is 4%<br><br>
     * <b>2° Discount Brand:</b> if the order has more than 800.0, the discount is 6%<br><br>
     * <b>3° Discount Brand:</b> if the order has more than 1000.0, the discount is 8%<br><br>
     *
     * @return {@code double}
     */
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
