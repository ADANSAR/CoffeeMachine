package com.coffeemachine.model;

import com.coffeemachine.interfaces.OrderMakerBehaviour;

public abstract class Order implements OrderMakerBehaviour {

    protected static final String SPLITER = ":";
    private String order;

    public Order() {
        // default constructor
    }

    public Order(String order) {
        this.order = order;
    }

}
