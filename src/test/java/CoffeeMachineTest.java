import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.coffeemachine.impl.CoffeeMachine;
import com.coffeemachine.model.Drink;
import com.coffeemachine.utils.DrinkType;

/**
 * Tests for CoffeeMachine
 */
public class CoffeeMachineTest {

    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK = "T:1:0 M:DrinkType maker makes 1 tea with 1 sugar and a stick";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK = "H:: M:DrinkType maker makes 1 chocolate with no sugar - and therefore no stick";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK = "C:2:0 M:DrinkType maker makes 1 coffee with 2 sugars and a stick";

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
    private void CoffeeMachineTest(final Drink inputDrink, final String expectedResult) {
        String realResult = cm.createOrder(inputDrink);
        assertEquals(expectedResult, realResult);
    }

    /**
     * Test of Chocolate With No Sugar No Stick
     */
    @Test
    public void TestChocolateWithNoSugarNoStick() {
        CoffeeMachineTest(new Drink(DrinkType.CHOCOLATE, 0), CHOCOLATE_WITH_NO_SUGAR_NO_STICK);
    }

    /**
     * Test of Coffee With Two Sugars And A Stick
     */
    @Test
    public void TestCoffeeWithTwoSugarsAndAStick() {
        CoffeeMachineTest(new Drink(DrinkType.COFFEE, 2), COFFEE_WITH_TWO_SUGARS_AND_A_STICK);
    }

    /**
     * Test of Tea With One Sugar And A Stick
     */
    @Test
    public void TestTeaWithOneSugarAndAStick() {
        CoffeeMachineTest(new Drink(DrinkType.TEA, 1), TEA_WITH_ONE_SUGAR_AND_A_STICK);
    }

}
