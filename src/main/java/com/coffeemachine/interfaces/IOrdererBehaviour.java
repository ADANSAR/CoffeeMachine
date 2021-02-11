package com.coffeemachine.interfaces;

import com.coffeemachine.model.Drink;

/**
 * IOrdererBehaviour
 */
public interface IOrdererBehaviour {

    /**
     * @param order
     *            the order to run
     *
     * @return the message of the order
     */
    String createOrder(final Drink drink);

}
