package com.coffeemachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.coffeemachine.utils.CoffeeMachineException;

public class Context {

    List<Order> orders = new ArrayList<>();

    /**
     *
     * @param orders
     */
    public Context(Order... orders) {
        Arrays.stream(orders).forEach(this.orders::add);
    }

    /**
     *
     * @param stringOrder
     *
     * @return the message of the order
     */
    public String proceed(final String stringOrder) {
        List<String> messageOrders = null;
        for (Order order : orders) {
            String messageOrder = order.make(stringOrder);
            if (StringUtils.isNotEmpty(messageOrder)) {
                messageOrders = new ArrayList<>();
                messageOrders.add(messageOrder);
            }
        }
        if (messageOrders == null || messageOrders.size() != 1) {
            throw new CoffeeMachineException("Invalid Command");
        }
        return messageOrders.get(0);
    }

}
