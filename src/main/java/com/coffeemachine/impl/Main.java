package com.coffeemachine.impl;

import org.javamoney.moneta.Money;

import com.coffeemachine.interfaces.IOrdererBehaviour;
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
        final IOrdererBehaviour myCoffeeMachine = new CoffeeMachine();
        System.out.println(
                myCoffeeMachine.createOrder(new Drink(DrinkType.CHOCOLATE, 2), Money.of(2, "EUR")));
    }

}
