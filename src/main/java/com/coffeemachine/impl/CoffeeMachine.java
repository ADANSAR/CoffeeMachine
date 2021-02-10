package com.coffeemachine.impl;

import com.coffeemachine.interfaces.DrinkMaker;
import com.coffeemachine.model.Context;
import com.coffeemachine.model.DrinkOrder;
import com.coffeemachine.model.MessageOrder;

public class CoffeeMachine implements DrinkMaker {

    /**
     * default constuctor
     */
    public CoffeeMachine() {
        super();
    }

    /**
     * @param order
     * @return result of the order
     */
    @Override
    public String runCoffeeMachine(final String order) {
        Context context = new Context(new DrinkOrder(order), new MessageOrder(order));
        return context.proceed(order);
    }

}
