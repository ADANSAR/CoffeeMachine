package com.coffeemachine.utils;

import javax.money.Monetary;

import org.javamoney.moneta.Money;

public enum DrinkType {

    /** coffee */
    COFFEE("C", "coffee", Money.of(0.6, "EUR"), true, true),
    /** chocolate */
    CHOCOLATE("H", "chocolate", Money.of(0.5, "EUR"), true, true),
    /** tea */
    TEA("T", "tea", Money.of(0.4, "EUR"), true, true),
    /** orange juice */
    ORANGE_JUICE("O", "orange juice", Money.of(0.6, "EUR"), false, false),
    /** lemon juice */
    LEMON_JUICE("L", "orange juice", Money.of(0.6, "EUR"), false, true);

    /** code of drink. */
    private final String abreviation;

    /** name of drink. */
    private final String name;

    /** cost of drink. */
    private final Money cost;

    /** true if the drink can be hot. */
    private final boolean canBeHot;

    /** true if the drink can be served with sugar. */
    private final boolean withSugar;

    /**
     *
     * @param abreviation
     *            code of drink
     */
    DrinkType(String abreviation, String name, Money cost, boolean canBeHot, boolean withSugar) {
        this.abreviation = abreviation;
        this.name = name;
        this.cost = cost;
        this.canBeHot = canBeHot;
        this.withSugar = withSugar;
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
     * @return true if the drink can be hot, else false.
     */
    public boolean canbeHot() {
        return canBeHot;
    }

    /**
     * @return true if the drink can be served with sugar, else false.
     */
    public boolean withSugar() {
        return canBeHot;
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
