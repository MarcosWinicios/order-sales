package com.studies.email;

import com.studies.model.Order;

public class EmailNotifier {

    public void send(Order order) {
        System.out.println("Sending email notification for order: "
                + order.getValue()
                + " to client: "
                + order.getClient().getEmail());
    }
}
