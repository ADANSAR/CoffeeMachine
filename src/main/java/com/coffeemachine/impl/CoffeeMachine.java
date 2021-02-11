package com.coffeemachine.impl;

import org.apache.commons.lang3.StringUtils;

import com.coffeemachine.interfaces.IOrdererBehaviour;
import com.coffeemachine.model.Drink;

public class CoffeeMachine implements IOrdererBehaviour {

    /**
     * default constuctor
     */
    public CoffeeMachine() {
        // Default constructor
    }

    @Override
    public String createOrder(Drink drink) {
        if (drink == null) {
            return StringUtils.EMPTY;
        }
        return createDrinkOrder(drink) + " " + createDrinkOrderMessage(drink);
    }

    private String createDrinkOrder(Drink drink) {
        StringBuilder sb = new StringBuilder();
        sb.append(drink.getDrinkType());
        sb.append(":");
        int sugar = drink.getSugar();
        if (sugar == 0) {
            sb.append(":");
        } else {
            sb.append(sugar);
            sb.append(":0");
        }
        return sb.toString();
    }

    private String createDrinkOrderMessage(Drink drink) {
        StringBuilder sb = new StringBuilder();
        sb.append("M:DrinkType maker makes 1 ");
        sb.append(drink.getDrinkName());
        sb.append(" with ");
        int sugar = drink.getSugar();
        if (sugar == 0) {
            sb.append("no sugar - and therefore no stick");
        } else if (sugar == 1) {
            sb.append(sugar);
            sb.append(" sugar and a stick");
        } else {
            sb.append(sugar);
            sb.append(" sugars and a stick");
        }
        return sb.toString();
    }
}
