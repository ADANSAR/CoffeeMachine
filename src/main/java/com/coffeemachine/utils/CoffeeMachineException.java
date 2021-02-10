package com.coffeemachine.utils;

public class CoffeeMachineException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    public CoffeeMachineException() {
    }

    public CoffeeMachineException(String message) {
        super(message);
    }

    public CoffeeMachineException(Throwable cause) {
        super(cause);

    }

    public CoffeeMachineException(String message, Throwable cause) {
        super(message, cause);

    }

    public CoffeeMachineException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
