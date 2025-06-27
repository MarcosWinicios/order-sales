package com.studies.email;

import com.studies.model.Order;
import com.studies.service.OrderLaunchAction;

public class EmailNotifier implements OrderLaunchAction {

    @Override
    public void execute(Order order) {
        System.out.println("Sending email notification for order: "
                + order.getValue()
                + " to client: "
                + order.getClient().getEmail());
    }
}
