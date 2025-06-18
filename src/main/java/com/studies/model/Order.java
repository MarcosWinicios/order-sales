package com.studies.model;

public class Order {

    private double value;
    private Client client;

    public Order (double value, Client client) {
        this.value = value;
        this.client = client;
    }

    public Order() {}

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
