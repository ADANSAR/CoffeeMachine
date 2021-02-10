import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.coffeemachine.impl.CoffeeMachine;

/**
 * Tests for CoffeeMachine
 */
public class CoffeeMachineTest {

    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK = "T:1:0";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK = "H::";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK = "C:2:0";
    static final String MESSAGE_TO_FORWARD = "M:message-content";

    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK_RESULT = "Drink maker makes 1 tea with 1 sugar and a stick";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK_RESULT = "Drink maker makes 1 chocolate with no sugar - and therefore no stick";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK_RESULT = "Drink maker makes 1 coffee with 2 sugars and a stick";
    static final String MESSAGE_TO_FORWARD_RESULT = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";

    private CoffeeMachine cm;

    /**
     * setUp for the test
     */
    @Before
    public void setUp() {
        cm = new CoffeeMachine();
    }

    /**
     * @param input
     *            input string
     * @param expectedResult
     *            the expected result
     */
    private void RunCoffeeMachine(final String input, final String expectedResult) {
        String realResult = cm.runCoffeeMachine(input);
        assertEquals(expectedResult, realResult);
    }

    /**
     * Test of Chocolate With No Sugar No Stick
     */
    @Test
    public void TestChocolateWithNoSugarNoStick() {
        RunCoffeeMachine(CHOCOLATE_WITH_NO_SUGAR_NO_STICK, CHOCOLATE_WITH_NO_SUGAR_NO_STICK_RESULT);
    }

    /**
     * Test of Coffee With Two Sugars And A Stick
     */
    @Test
    public void TestCoffeeWithTwoSugarsAndAStick() {
        RunCoffeeMachine(COFFEE_WITH_TWO_SUGARS_AND_A_STICK,
                COFFEE_WITH_TWO_SUGARS_AND_A_STICK_RESULT);
    }

    /**
     * Test of Tea With One Sugar And A Stick
     */
    @Test
    public void TestTeaWithOneSugarAndAStick() {
        RunCoffeeMachine(TEA_WITH_ONE_SUGAR_AND_A_STICK, TEA_WITH_ONE_SUGAR_AND_A_STICK_RESULT);
    }

    /**
     * Test of Message To Forward
     */
    @Test
    public void TestMessageToForward() {
        RunCoffeeMachine(MESSAGE_TO_FORWARD, MESSAGE_TO_FORWARD_RESULT);
    }

}
