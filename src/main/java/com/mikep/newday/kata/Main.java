package com.mikep.newday.kata;

import com.mikep.newday.kata.exception.InvalidInputException;
import com.mikep.newday.kata.generator.DiamondGenerator;
import com.mikep.newday.kata.input.InputParser;

/**
 * Main method for running diamond generator.
 */
public class Main {
    public static void main(final String[] args) {
        final var generator = new DiamondGenerator();
        try {
            System.out.println(generator.generateOutput(InputParser.parseInput(args)));
        } catch (final InvalidInputException e) {
            System.out.println("Invalid input provided. " + e.getMessage());
        }
    }
}
