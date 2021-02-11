import static org.junit.Assert.assertEquals;

import org.javamoney.moneta.Money;
import org.junit.Before;
import org.junit.Test;

import com.coffeemachine.impl.CoffeeMachine;
import com.coffeemachine.model.Drink;
import com.coffeemachine.utils.DrinkType;

/**
 * Tests for CoffeeMachine
 */
public class CoffeeMachineTest {

    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK_ENOUGH_MONEY = "T:1:0 M:DrinkType maker makes 1 tea with 1 sugar and a stick";
    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK_LESS_MONEY = "M:0.2 EUR is missing to order the drink.";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK_ENOUGH_MONEY = "H:: M:DrinkType maker makes 1 chocolate with no sugar - and therefore no stick";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK_LESS_MONEY = "M:0.1 EUR is missing to order the drink.";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK_ENOUGH_MONEY = "C:2:0 M:DrinkType maker makes 1 coffee with 2 sugars and a stick";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK_LESS_MONEY = "M:0.2 EUR is missing to order the drink.";

    private CoffeeMachine cm;

    /**
     * setUp for the test
     */
    @Before
    public void setUp() {
        cm = new CoffeeMachine();
    }

    /**
     * @param inputDrink
     *            input Drink
     * @param expectedResult
     *            the expected result
     */
    private void CoffeeMachineTest(final Drink inputDrink, final Money inputMoney,
            final String expectedResult) {
        String realResult = cm.createOrder(inputDrink, inputMoney);
        assertEquals(expectedResult, realResult);
    }

    /**
     * Test of Chocolate With No Sugar No Stick With Enough Money
     */
    @Test
    public void TestChocolateWithNoSugarNoStickWithEnoughMoney() {
        CoffeeMachineTest(new Drink(DrinkType.CHOCOLATE, 0), Money.of(0.5, "EUR"),
                CHOCOLATE_WITH_NO_SUGAR_NO_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Chocolate With No Sugar No Stick With Less Money
     */
    @Test
    public void TestChocolateWithNoSugarNoStickWithLessMoney() {
        CoffeeMachineTest(new Drink(DrinkType.CHOCOLATE, 0), Money.of(0.4, "EUR"),
                CHOCOLATE_WITH_NO_SUGAR_NO_STICK_LESS_MONEY);
    }

    /**
     * Test of Coffee With Two Sugars And A Stick
     */
    @Test
    public void TestCoffeeWithTwoSugarsAndAStickWithEnoughMoney() {
        CoffeeMachineTest(new Drink(DrinkType.COFFEE, 2), Money.of(0.6, "EUR"),
                COFFEE_WITH_TWO_SUGARS_AND_A_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Coffee With Two Sugars And A Stick
     */
    @Test
    public void TestCoffeeWithTwoSugarsAndAStickWithLessMoney() {
        CoffeeMachineTest(new Drink(DrinkType.COFFEE, 2), Money.of(0.4, "EUR"),
                COFFEE_WITH_TWO_SUGARS_AND_A_STICK_LESS_MONEY);
    }

    /**
     * Test of Tea With One Sugar And A Stick
     */
    @Test
    public void TestTeaWithOneSugarAndAStickWithEnoughMoney() {
        CoffeeMachineTest(new Drink(DrinkType.TEA, 1), Money.of(0.4, "EUR"),
                TEA_WITH_ONE_SUGAR_AND_A_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Tea With One Sugar And A Stick
     */
    @Test
    public void TestTeaWithOneSugarAndAStickWithLessMoney() {
        CoffeeMachineTest(new Drink(DrinkType.TEA, 1), Money.of(0.2, "EUR"),
                TEA_WITH_ONE_SUGAR_AND_A_STICK_LESS_MONEY);
    }

}
