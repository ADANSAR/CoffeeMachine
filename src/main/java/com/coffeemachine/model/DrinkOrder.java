package com.coffeemachine.model;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.coffeemachine.utils.Drink;

public class DrinkOrder extends Order {

    private static final int DRINK_ORDER_SIZE = 3;

    private Drink drink;
    private int sugar;

    public DrinkOrder(String orderToMake) {
        super(orderToMake);
        List<String> instructions = Arrays.asList(orderToMake.split(SPLITER, -1));
        if (instructions.size() == DRINK_ORDER_SIZE) {
            String inputDrink = instructions.get(0);
            drink = Drink.getDrinkFromCode(inputDrink);
            String inputSugar = instructions.get(1);
            sugar = inputSugar.isEmpty() ? 0 : Integer.valueOf(inputSugar);
        }
    }

    @Override
    public String make(String orderToMake) {
        if (drink == null) {
            return StringUtils.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Drink maker makes 1 ");
        sb.append(drink.getName());
        sb.append(" with ");
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
