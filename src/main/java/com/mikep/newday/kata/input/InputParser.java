package com.mikep.newday.kata.input;

import com.mikep.newday.kata.exception.InvalidInputException;

/**
 * InputParser is a utility for parsing an array of String parameters and applying business logic.
 */
public class InputParser {
    public static final String INPUT_TOO_LONG = "Please ensure a single character is entered";
    public static final String NON_UPPERCASE_OR_NON_ALPHABETICAL_CHARACTER = "Please ensure an uppercase alphabetical character is entered";

    /**
     * parseInput is a method for parsing an array of String parameters.
     * @param inputToParse parameters ot parse
     * @return a String representing the parsed value
     * @throws InvalidInputException in case input does not match expected input.
     */
    public static char parseInput(final String[] inputToParse) throws InvalidInputException {
        if(inputToParse == null || inputToParse.length != 1)
        {
            throw new InvalidInputException(INPUT_TOO_LONG);
        }
        final var character = inputToParse[0];
        if(!character.matches("[A-Z]")) {
            throw new InvalidInputException(NON_UPPERCASE_OR_NON_ALPHABETICAL_CHARACTER);
        }
        return character.charAt(0);
    }
}
