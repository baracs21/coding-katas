package de.baracs.kata.diamond.usecases;

import de.baracs.kata.diamond.exceptions.InvalidLetterException;

public class CreateDiamond {

    public String createDiamond(char letter) {
        int START = 65;
        int MAX = 90;

        if ((int) letter < START || (int) letter > MAX) {
            throw new InvalidLetterException(String.valueOf(letter));
        }

        StringBuilder result = new StringBuilder();

        int interspace = 1;
        int leadingSpaces = letter - START;

        for (int i = START; i <= (int) letter; i++) {
            result.append(" ".repeat(Math.max(0, leadingSpaces)));

            result.append((char) i);

            if (i != (int) letter)
                leadingSpaces--;

            if (i != START) {
                result.append(" ".repeat(Math.max(0, interspace)));

                result.append((char) i);
                if (i != (int) letter)
                    interspace += 2;

            }
            result.append('\n');
        }

        for (int i = (int) letter -1; i >= START; i--) {
            result.append(" ".repeat(Math.max(0, leadingSpaces + 1)));
            result.append((char) i);

            leadingSpaces++;

            if (i != START) {
                result.append(" ".repeat(Math.max(0, interspace - 2)));
                result.append((char)i);
                interspace-=2;
            }

            result.append("\n");
        }

        return result.toString();
    }

}
