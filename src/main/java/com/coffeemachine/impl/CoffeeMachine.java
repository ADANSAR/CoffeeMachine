package com.coffeemachine.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.javamoney.moneta.Money;

import com.coffeemachine.interfaces.IOrdererBehaviour;
import com.coffeemachine.model.Drink;
import com.coffeemachine.utils.DrinkType;

public class CoffeeMachine implements IOrdererBehaviour {

    List<DrinkType> coldDrinks = Arrays.asList(DrinkType.ORANGE_JUICE);

    /**
     * default constuctor
     */
    public CoffeeMachine() {
        // Default constructor
    }

    @Override
    public String createOrder(Drink drink, Money money) {
        if (drink == null) {
            return StringUtils.EMPTY;
        }
        if (drink.isInputMoneyEnough(money)) {
            return createDrinkOrder(drink) + " " + createDrinkOrderMessage(drink);
        } else {
            Money missingMoney = drink.computeMissingMoney(money);
            return createDrinkOrderWithLessMoney(missingMoney);
        }
    }

    private String createDrinkOrder(Drink drink) {
        StringBuilder sb = new StringBuilder();
        sb.append(drink.getDrinkTypeWithTemperature());
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
        sb.append("M:Drink maker makes 1 ");
        sb.append(drink.getDrinkNameWithTemperature());
        boolean isColdDrink = coldDrinks.stream().map(DrinkType::getAbreviation)
                .anyMatch(a -> a.equals(drink.getDrinkType()));
        if (!isColdDrink) {
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
        }
        return sb.toString();
    }

    public String createDrinkOrderWithLessMoney(Money missingMoney) {
        StringBuilder sb = new StringBuilder();
        sb.append("M:");
        sb.append(missingMoney.getNumber());
        sb.append(" ");
        sb.append(missingMoney.getCurrency());
        sb.append(" is missing to order the drink.");
        return sb.toString();
    }

    public void printStats() {
        System.out.print("Hello World");
    }
}
