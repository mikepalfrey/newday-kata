package com.mikep.newday.kata.exception;

/**
 * Exception representing invalid input.
 */
public class InvalidInputException extends Exception {

    /**
     * InvalidInputException represents the exception thrown if invalid input is received.
     * @param message the Exception's message.
     */
    public InvalidInputException(final String message) {
        super(message);
    }
}
