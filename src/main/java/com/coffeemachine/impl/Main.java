package com.coffeemachine.impl;

import org.javamoney.moneta.Money;

import com.coffeemachine.model.Drink;
import com.coffeemachine.utils.DrinkType;

/**
 * Main
 */
public final class Main {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final CoffeeMachine myCoffeeMachine = new CoffeeMachine();
        myCoffeeMachine.createOrder(new Drink(DrinkType.TEA), Money.of(.9, "EUR"));
        myCoffeeMachine.createOrder(new Drink(DrinkType.COFFEE, 1), Money.of(.8, "EUR"));
        myCoffeeMachine.createOrder(new Drink(DrinkType.ORANGE_JUICE), Money.of(.6, "EUR"));
        myCoffeeMachine.createOrder(new Drink(DrinkType.CHOCOLATE, 2), Money.of(.8, "EUR"));
        myCoffeeMachine.createOrder(new Drink(DrinkType.CHOCOLATE, 2), Money.of(.4, "EUR"));
        myCoffeeMachine.printStats();
    }

}
