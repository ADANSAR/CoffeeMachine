package com.coffeemachine.interfaces;

/**
 * DrinkMaker
 */
public interface DrinkMaker {

    /**
     * @param order
     *            the order to run
     *
     * @return the message of the order
     */
    String runCoffeeMachine(final String order);

}
