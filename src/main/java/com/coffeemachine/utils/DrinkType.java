package com.coffeemachine.utils;

import javax.money.Monetary;

import org.javamoney.moneta.Money;

public enum DrinkType {

    /** coffee */
    COFFEE("C", "coffee", Money.of(0.60, "EUR")),
    /** chocolate */
    CHOCOLATE("H", "chocolate", Money.of(0.50, "EUR")),
    /** tea */
    TEA("T", "tea", Money.of(0.40, "EUR"));

    /** code of drink. */
    private final String abreviation;

    /** name of drink. */
    private final String name;

    /** cost of drink. */
    private final Money cost;

    /**
     *
     * @param abreviation
     *            code of drink
     */
    DrinkType(String abreviation, String name, Money cost) {
        this.abreviation = abreviation;
        this.name = name;
        this.cost = cost;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the abreviation
     */
    public String getAbreviation() {
        return abreviation;
    }

    /**
     * @return the cost
     */
    public Money getCost() {
        return cost;
    }

    /**
     *
     * @param codeDrink
     *            code of drink
     * @return enum drink corresponding to the codeDrink or null if not found
     */
    public static DrinkType getDrinkFromCode(String codeDrink) {
        for (DrinkType drink : DrinkType.values()) {
            if (drink.getAbreviation().equalsIgnoreCase(codeDrink)) {
                return drink;
            }
        }
        return null;
    }

    /**
     *
     * @param inputMoney
     *            the input money
     * @return true if the money is enough to get the drink
     */
    public boolean isInputMoneyEnough(Money inputMoney) {
        return cost.subtract(Monetary.getDefaultRounding().apply(inputMoney)).isPositiveOrZero();
    }
}
