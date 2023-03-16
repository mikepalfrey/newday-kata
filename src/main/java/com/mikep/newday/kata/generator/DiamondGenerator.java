package com.mikep.newday.kata.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * DiamondGenerator is a class for rendering a diamond representing all characters in the alphabet that come before
 * a provided character.
 */
public class DiamondGenerator {

    /**
     * generateOutput is a method for accepting an input character and generating the required format
     * of output.
     * @param character the input character to render the diamond for.
     * @return a String containing the output.
     */
    public String generateOutput(final char character) {
        final var alphabet = IntStream.rangeClosed('A', character)
                .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();
        final var characterIndex = alphabet.length - 1;
        //Instantiate a list to store the output.
        final var outputLength = characterIndex == 0 ? 1 : (characterIndex * 2) - 1;
        final var output = new ArrayList<>(outputLength);
        //Calculate how long the line is required to be
        final var lengthOfLine = ((characterIndex + 1) * 2) - 1;
        //Generate top half of diamond
        for (int i = 0; i < alphabet.length; i++) {
            final var charIndex = alphabet.length - i - 1;
            output.add(generateLine(alphabet[i], charIndex, lengthOfLine, i));
        }
        //The second half of the diamond is the same as the first, minus the last element in the list, so simply reverse
        final var subList = new ArrayList<>(output.subList(0, output.size() - 1));
        Collections.reverse(subList);
        output.addAll(subList);

        //Then format it into a StringBuilder, separating each line with a new line.
        final var formattedOutput = new StringBuilder();
        for (int i = 0; i < output.size(); i++) {
            formattedOutput.append(output.get(i));
            if(i != output.size() - 1) {
                formattedOutput.append("\n");
            }
        }
        return formattedOutput.toString();
    }

    /**
     * generateLine is used to generate a String representing a line within the diamond.
     * @param charToPrint the character we wish to print.
     * @param charIndex the index for which we want the character to be in.
     * @param lengthOfLine the length of the line we wish to render
     * @param lineNumberInDiamond the number of the line in the diamond we are rendering.
     * @return a String representing the line of the diamond.
     */
    protected String generateLine(final char charToPrint, final int charIndex, final int lengthOfLine, final int lineNumberInDiamond) {
        final var lineOutput = new char[lengthOfLine];
        for (int i = 0; i < lineOutput.length; i++) {
            lineOutput[i] = '_';
        }
        lineOutput[charIndex] = charToPrint;

        //If not the first line, add the second character in the correct place.
        if (lineNumberInDiamond > 0) {
            final var idx = lengthOfLine - charIndex - 1;
            lineOutput[idx] = charToPrint;
        }
        return new String(lineOutput);
    }
}
