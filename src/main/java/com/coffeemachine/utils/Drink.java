package com.coffeemachine.utils;

public enum Drink {

    /** coffee */
    COFFEE("C", "coffee"),
    /** chocolate */
    CHOCOLATE("H", "chocolate"),
    /** tea */
    TEA("T", "tea");

    /** code of drink. */
    private final String abreviation;

    /** name of drink. */
    private final String name;

    /**
     *
     * @param abreviation
     *            code of drink
     */
    Drink(String abreviation, String name) {
        this.abreviation = abreviation;
        this.name = name;
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
     *
     * @param codeDrink
     *            code of drink
     * @return enum drink corresponding to the codeDrink or null if not found
     */
    public static Drink getDrinkFromCode(String codeDrink) {
        for (Drink drink : Drink.values()) {
            if (drink.getAbreviation().equalsIgnoreCase(codeDrink)) {
                return drink;
            }
        }
        return null;
    }
}
