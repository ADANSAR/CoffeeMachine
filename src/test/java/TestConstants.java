/**
 * Constants the CoffeeMachine tests
 */
public class TestConstants {

    private TestConstants() {
        super();
    }

    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK = "T:1:0";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK = "H::";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK = "C:2:0";
    static final String MESSAGE_TO_FORWARD = "M:message-content";

    static final String TEA_WITH_ONE_SUGAR_AND_A_STICK_RESULT = "Drink maker makes 1 tea with 1 sugar and a stick";
    static final String CHOCOLATE_WITH_NO_SUGAR_NO_STICK_RESULT = "Drink maker makes 1 chocolate with no sugar - and therefore no stick";
    static final String COFFEE_WITH_TWO_SUGARS_AND_A_STICK_RESULT = "Drink maker makes 1 coffee with 2 sugars and a stick";
    static final String MESSAGE_TO_FORWARD_RESULT = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";

}
