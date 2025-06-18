package com.studies.sms;

import com.studies.model.Order;

public class SmsNotifier {

    public void send(Order order) {
        System.out.println("Sending sms notification for order: "
                + order.getValue()
                + " to client: "
                + order.getClient().getEmail());
    }
}
