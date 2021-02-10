package com.coffeemachine.model;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MessageOrder extends Order {

    private static final int DRINK_ORDER_SIZE = 2;
    private static final String MESSAGE_CODE = "M";

    private String message;

    public MessageOrder(String orderToMake) {
        super(orderToMake);
        List<String> instructions = Arrays.asList(orderToMake.split(SPLITER, -1));
        if (instructions.size() == DRINK_ORDER_SIZE) {
            String inputCode = instructions.get(0);
            if (inputCode.equalsIgnoreCase(MESSAGE_CODE)) {
                String inputMessage = instructions.get(1);
                message = inputMessage;
            }
        }
    }

    @Override
    public String make(String orderToMake) {
        if (message == null) {
            return StringUtils.EMPTY;
        }
        return "Drink maker forwards any message received onto the coffee machine interface for the customer to see";
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
