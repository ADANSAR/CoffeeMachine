package com.coffeemachine.impl;

import com.coffeemachine.interfaces.DrinkMaker;

/**
 * Main
 */
public final class Main {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final DrinkMaker myDrinkMaker = new CoffeeMachine();
        System.out.println(myDrinkMaker.runCoffeeMachine("T:1:0"));
    }

}
