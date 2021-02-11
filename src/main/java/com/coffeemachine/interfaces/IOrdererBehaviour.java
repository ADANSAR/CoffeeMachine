package com.coffeemachine.interfaces;

import org.javamoney.moneta.Money;

import com.coffeemachine.model.Drink;

/**
 * IOrdererBehaviour
 */
public interface IOrdererBehaviour {

    /**
     * @param order
     *            the order to run
     * @param money
     *            the paid money
     *
     * @return the message of the order
     */
    String createOrder(final Drink drink, final Money money);

}
