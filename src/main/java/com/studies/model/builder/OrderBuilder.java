package com.studies.model.builder;

import com.studies.model.Client;
import com.studies.model.Order;

public class OrderBuilder {

    private Order instance;

    public OrderBuilder() {
        this.instance = new Order();
    }

    public Order build() {
        return this.instance;
    }

    public OrderBuilder withValue(double value) {
        this.instance.setValue(value);
        return this;
    }

    public OrderBuilder to(String name, String email, String phone) {
        Client client = new Client(name, email, phone);
        this.instance.setClient(client);
        return this;
    }
}
