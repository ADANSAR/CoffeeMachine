package com.coffeemachine.model;

import org.javamoney.moneta.Money;

import com.coffeemachine.utils.DrinkType;

public class Drink {

    private DrinkType drinkType;
    private int sugar = 0;
    private boolean isExtraHot = false;

    public Drink(DrinkType drink) {
        drinkType = drink;
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
        if (canBeServedWithSugar()) {
            this.sugar = sugar;
        }
    }

    /**
     * @param sugar
     *            the sugar to set
     * @return the Drink
     */
    public Drink withSugar(int sugar) {
        if (canBeServedWithSugar()) {
            this.sugar = sugar;
        }
        return this;
    }

    /**
     * @return true if the drink can be served with sugar, else false.
     */
    public boolean canBeServedWithSugar() {
        return drinkType.withSugar();
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
     * @return the drinkType cost
     */
    public Money getCost() {
        return drinkType.getCost();
    }

    /**
     * @return true if the drink can be hot, else false.
     */
    public boolean canBeHot() {
        return drinkType.canbeHot();
    }

    /**
     * @param inputMoney
     *            the input money
     *
     * @return true if inputMoney are enough to get the drink, else false.
     */
    public boolean isInputMoneyEnough(Money inputMoney) {
        return inputMoney.subtract(getCost()).isPositiveOrZero();
    }

    /**
     * @param inputMoney
     *            the input money
     *
     * @return the amount of missing money.
     */
    public Money computeMissingMoney(Money inputMoney) {
        return getCost().subtract(inputMoney);
    }

    /**
     * @return the isExtraHot
     */
    public boolean isExtraHot() {
        return isExtraHot;
    }

    /**
     * @param isExtraHot
     *            the isExtraHot to set
     */
    public void setExtraHot(boolean isExtraHot) {
        if (canBeHot()) {
            this.isExtraHot = isExtraHot;
        }
    }

    /**
     * @return the drinkType abreviation with its temperature
     */
    public String getDrinkTypeWithTemperature() {
        if (isExtraHot) {
            return drinkType.getAbreviation() + "h";
        } else {
            return drinkType.getAbreviation();
        }
    }

    /**
     * @return the drinkType name with its temperature
     */
    public String getDrinkNameWithTemperature() {
        if (isExtraHot) {
            return "extra hot " + drinkType.getName();
        } else {
            return drinkType.getName();
        }
    }

}
