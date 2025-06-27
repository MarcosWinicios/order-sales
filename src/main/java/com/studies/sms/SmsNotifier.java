package com.studies.sms;

import com.studies.model.Order;
import com.studies.service.OrderLaunchAction;

public class SmsNotifier implements OrderLaunchAction {


    @Override
    public void execute(Order order) {

        System.out.println("Sending sms notification for order: "
                + order.getValue()
                + " to client: "
                + order.getClient().getEmail());

    }
}
