import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.coffeemachine.impl.CoffeeMachine;

/**
 * Tests for CoffeeMachine
 */
public class CoffeeMachineTest {

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
        RunCoffeeMachine(TestConstants.CHOCOLATE_WITH_NO_SUGAR_NO_STICK,
                TestConstants.CHOCOLATE_WITH_NO_SUGAR_NO_STICK_RESULT);
    }

    /**
     * Test of Coffee With Two Sugars And A Stick
     */
    @Test
    public void TestCoffeeWithTwoSugarsAndAStick() {
        RunCoffeeMachine(TestConstants.COFFEE_WITH_TWO_SUGARS_AND_A_STICK,
                TestConstants.COFFEE_WITH_TWO_SUGARS_AND_A_STICK_RESULT);
    }

    /**
     * Test of Tea With One Sugar And A Stick
     */
    @Test
    public void TestTeaWithOneSugarAndAStick() {
        RunCoffeeMachine(TestConstants.TEA_WITH_ONE_SUGAR_AND_A_STICK,
                TestConstants.TEA_WITH_ONE_SUGAR_AND_A_STICK_RESULT);
    }

    /**
     * Test of Message To Forward
     */
    @Test
    public void TestMessageToForward() {
        RunCoffeeMachine(TestConstants.MESSAGE_TO_FORWARD, TestConstants.MESSAGE_TO_FORWARD_RESULT);
    }

}
