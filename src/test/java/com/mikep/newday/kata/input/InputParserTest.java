package com.mikep.newday.kata.input;

import com.mikep.newday.kata.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class InputParserTest {

    InputParser parser;

    @Before
    public void setUp() {
        parser = new InputParser();
    }

    @Test
    public void testValidInput() throws InvalidInputException {
        final String[] validInput = new String[]{"A"};
        final var expectedResponse = 'A';
        final var actualResponse = parser.parseInput(validInput);
        assertEquals("Expected input to match expected response", expectedResponse, actualResponse);
    }

    @Test
    public void testInvalidInputLength() {
        final String[] invalidInput = new String[]{"A", "B"};
        final InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> parser.parseInput(invalidInput));
        assertEquals("Expected exception message to be set", InputParser.INPUT_TOO_LONG, exception.getMessage());
    }

    @Test
    public void testInvalidInputNonAlphanumeric() {
        final String[] invalidInput = new String[]{"@"};
        final InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> parser.parseInput(invalidInput));
        assertEquals("Expected exception message to be set", InputParser.NON_UPPERCASE_OR_NON_ALPHABETICAL_CHARACTER, exception.getMessage());
    }

    @Test
    public void testInvalidInputLowercaseCharacters() {
        final String[] invalidInput = new String[]{"a"};
        final InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> parser.parseInput(invalidInput));
        assertEquals("Expected exception message to be set", InputParser.NON_UPPERCASE_OR_NON_ALPHABETICAL_CHARACTER, exception.getMessage());
    }

    @Test
    public void testInvalidInputNumericCharacters() {
        final String[] invalidInput = new String[]{"1"};
        final InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> parser.parseInput(invalidInput));
        assertEquals("Expected exception message to be set", InputParser.NON_UPPERCASE_OR_NON_ALPHABETICAL_CHARACTER, exception.getMessage());
    }

    @Test
    public void testInvalidInputAlphaNumericCharactersTooLong() {
        final String[] invalidInput = new String[]{"1", "A"};
        final InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> parser.parseInput(invalidInput));
        assertEquals("Expected exception message to be set", InputParser.INPUT_TOO_LONG, exception.getMessage());
    }
}
