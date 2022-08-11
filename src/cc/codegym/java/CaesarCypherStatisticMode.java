package cc.codegym.java;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CaesarCypherStatisticMode {

    private static final char LETTER_A = 'a';
    private static final char LETTER_Z = 'z';
    private static final int ALPHABET_SIZE = LETTER_Z - LETTER_A + 1;

    //frequency taken from Wikipedia https://en.wikipedia.org/wiki/Letter_frequency
    private static final double[] ENGLISH_LETTERS_PROBABILITIES = {0.081, 0.014, 0.027, 0.042, 0.127, 0.022, 0.020, 0.060,0.069,0.0015,
            0.00772, 0.040, 0.024, 0.067, 0.075, 0.192, 0.00095,0.059, 0.063, 0.090, 0.027, 0.00978,0.023,0.00015, 0.019, 0.00074};

    public String cipher(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - LETTER_A;
                int newAlphabetPosition = (originalAlphabetPosition + key) % ALPHABET_SIZE;
                char newCharacter = (char) (LETTER_A + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public String decipher(String message, int key) {
        return cipher(message, ALPHABET_SIZE - (key % ALPHABET_SIZE));
    }

    public int breakCipher(String message) {
        return probableOffset(chiSquares(message));
    }

    private double[] chiSquares(String message) {
        double[] expectedLettersFrequencies = expectedLettersFrequencies(message.length());

        double[] chiSquares = new double[ALPHABET_SIZE];

        for (int key = 0; key < chiSquares.length; key++) {
            String decipheredMessage = decipher(message, key);
            long[] lettersFrequencies = observedLettersFrequencies(decipheredMessage);
            double chiSquare = new ChiSquareTest().chiSquare(expectedLettersFrequencies, lettersFrequencies);
            chiSquares[key] = chiSquare;
        }

        return chiSquares;
    }

    private long[] observedLettersFrequencies(String message) {
        return IntStream.rangeClosed(LETTER_A, LETTER_Z)
                .mapToLong(letter -> countLetter((char) letter, message))
                .toArray();
    }

    private long countLetter(char letter, String message) {
        return message.chars()
                .filter(character -> character == letter)
                .count();
    }

    private double[] expectedLettersFrequencies(int messageLength) {
        return Arrays.stream(ENGLISH_LETTERS_PROBABILITIES)
                .map(probability -> probability * messageLength)
                .toArray();
    }

    private int probableOffset(double[] chiSquares) {
        int probableKey = 0;
        for (int key = 0; key < chiSquares.length; key++) {
            if (chiSquares[key] < chiSquares[probableKey]) {
                probableKey = key;
            }
        }

        return probableKey;
    }
}
