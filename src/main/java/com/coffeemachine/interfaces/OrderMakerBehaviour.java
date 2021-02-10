package com.coffeemachine.interfaces;

public interface OrderMakerBehaviour {

    /**
     *
     * @param order
     *            the order to make
     *
     * @return the string containing the formatted order
     */
    public String make(final String orderToMake);

}
