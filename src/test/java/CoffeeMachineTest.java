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

    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK_ENOUGH_MONEY = "T:1:0 M:Drink maker makes 1 tea with 1 sugar and a stick";
    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK_LESS_MONEY = "M:0.2 EUR is missing to order the drink.";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK_ENOUGH_MONEY = "H:: M:Drink maker makes 1 chocolate with no sugar - and therefore no stick";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK_LESS_MONEY = "M:0.1 EUR is missing to order the drink.";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK_ENOUGH_MONEY = "C:2:0 M:Drink maker makes 1 coffee with 2 sugars and a stick";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK_LESS_MONEY = "M:0.2 EUR is missing to order the drink.";
    static final String EXTRA_HOT_TEA_WITH_TWO_SUGARS_AND_A_STICK_ENOUGH_MONEY = "Th:2:0 M:Drink maker makes 1 extra hot tea with 2 sugars and a stick";
    static final String EXTRA_HOT_CHOCOLATE_WITH_ONE_SUGAR_AND_A_STICK_ENOUGH_MONEY = "Hh:1:0 M:Drink maker makes 1 extra hot chocolate with 1 sugar and a stick";
    static final String EXTRA_HOT_COFFEE_WITH_NO_SUGAR_NO_STICK_ENOUGH_MONEY = "Ch:: M:Drink maker makes 1 extra hot coffee with no sugar - and therefore no stick";
    static final String ORANGE_JUICE_ENOUGH_MONEY = "O:: M:Drink maker makes 1 orange juice";

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
    private void RunCoffeeMachineTest(final Drink inputDrink, final Money inputMoney,
            final String expectedResult) {
        String realResult = cm.createOrder(inputDrink, inputMoney);
        assertEquals(expectedResult, realResult);
    }

    /**
     * Test of Chocolate With No Sugar No Stick With Enough Money
     */
    @Test
    public void TestChocolateWithNoSugarNoStickWithEnoughMoney() {
        RunCoffeeMachineTest(new Drink(DrinkType.CHOCOLATE, 0), Money.of(0.5, "EUR"),
                CHOCOLATE_WITH_NO_SUGAR_NO_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Chocolate With No Sugar No Stick With Less Money
     */
    @Test
    public void TestChocolateWithNoSugarNoStickWithLessMoney() {
        RunCoffeeMachineTest(new Drink(DrinkType.CHOCOLATE, 0), Money.of(0.4, "EUR"),
                CHOCOLATE_WITH_NO_SUGAR_NO_STICK_LESS_MONEY);
    }

    /**
     * Test of Coffee With Two Sugars And A Stick
     */
    @Test
    public void TestCoffeeWithTwoSugarsAndAStickWithEnoughMoney() {
        RunCoffeeMachineTest(new Drink(DrinkType.COFFEE, 2), Money.of(0.6, "EUR"),
                COFFEE_WITH_TWO_SUGARS_AND_A_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Coffee With Two Sugars And A Stick
     */
    @Test
    public void TestCoffeeWithTwoSugarsAndAStickWithLessMoney() {
        RunCoffeeMachineTest(new Drink(DrinkType.COFFEE, 2), Money.of(0.4, "EUR"),
                COFFEE_WITH_TWO_SUGARS_AND_A_STICK_LESS_MONEY);
    }

    /**
     * Test of Tea With One Sugar And A Stick
     */
    @Test
    public void TestTeaWithOneSugarAndAStickWithEnoughMoney() {
        RunCoffeeMachineTest(new Drink(DrinkType.TEA, 1), Money.of(0.4, "EUR"),
                TEA_WITH_ONE_SUGAR_AND_A_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Tea With One Sugar And A Stick
     */
    @Test
    public void TestTeaWithOneSugarAndAStickWithLessMoney() {
        RunCoffeeMachineTest(new Drink(DrinkType.TEA, 1), Money.of(0.2, "EUR"),
                TEA_WITH_ONE_SUGAR_AND_A_STICK_LESS_MONEY);
    }

    /**
     * Test of Extra Hot Chocolate With One Sugar And A Stick With Enough Money
     */
    @Test
    public void TestExtraHotChocolateWithOneSugarAndAStickWithEnoughMoney() {
        Drink drink = new Drink(DrinkType.CHOCOLATE, 1);
        drink.setExtraHot(true);
        RunCoffeeMachineTest(drink, Money.of(0.5, "EUR"),
                EXTRA_HOT_CHOCOLATE_WITH_ONE_SUGAR_AND_A_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Extra Hot Coffee With No Sugar No Stick With Enough Money
     */
    @Test
    public void TestExtraHotCoffeeWithnoSugarNoStickWithEnoughMoney() {
        Drink drink = new Drink(DrinkType.COFFEE, 0);
        drink.setExtraHot(true);
        RunCoffeeMachineTest(drink, Money.of(0.6, "EUR"),
                EXTRA_HOT_COFFEE_WITH_NO_SUGAR_NO_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Extra Hot Tea With Two Sugars And A Stick With Enough Money
     */
    @Test
    public void TestExtraHotTeaWithTwoSugarsAndAStickWithEnoughMoney() {
        Drink drink = new Drink(DrinkType.TEA, 2);
        drink.setExtraHot(true);
        RunCoffeeMachineTest(drink, Money.of(0.4, "EUR"),
                EXTRA_HOT_TEA_WITH_TWO_SUGARS_AND_A_STICK_ENOUGH_MONEY);
    }

    /**
     * Test of Orange Juice With Enough Money
     */
    @Test
    public void TestOrangeJuiceWithEnoughMoney() {
        Drink drink = new Drink(DrinkType.ORANGE_JUICE);
        RunCoffeeMachineTest(drink, Money.of(0.6, "EUR"), ORANGE_JUICE_ENOUGH_MONEY);
    }

}
