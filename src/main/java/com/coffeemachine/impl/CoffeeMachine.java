package com.coffeemachine.impl;

import com.coffeemachine.model.Drink;

public class CoffeeMachine {

    /**
     * default constuctor
     */
    public CoffeeMachine() {
        // Default constructor
    }

    public String createOrder(Drink drink) {
        return drink.getDrinkName();
    }
}