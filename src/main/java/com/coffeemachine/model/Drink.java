package com.coffeemachine.model;

import com.coffeemachine.utils.DrinkType;

public class Drink {

    private DrinkType drinkType;
    private int sugar;

    public Drink(DrinkType drink, int sugar) {
        drinkType = drink;
        this.sugar = sugar;
    }

    /**
     * @return the drinkType
     */
    public DrinkType getDrink() {
        return drinkType;
    }

    /**
     * @param drinkType
     *            the drinkType to set
     */
    public void setDrink(DrinkType drink) {
        drinkType = drink;
    }

    /**
     * @return the sugar
     */
    public int getSugar() {
        return sugar;
    }

    /**
     * @param sugar
     *            the sugar to set
     */
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    /**
     * @return the drinkType name
     */
    public String getDrinkName() {
        return drinkType.getName();
    }

    /**
     * @return the drinkType abreviation
     */
    public String getDrinkType() {
        return drinkType.getAbreviation();
    }

    /**
     * @param sugar
     *            the sugar to add
     */
    public void addSugar(int sugar) {
        this.sugar += sugar;
    }
}
