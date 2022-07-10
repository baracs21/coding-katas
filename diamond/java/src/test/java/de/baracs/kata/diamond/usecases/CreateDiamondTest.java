package de.baracs.kata.diamond.usecases;

import de.baracs.kata.diamond.exceptions.InvalidLetterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateDiamondTest {

    CreateDiamond diamondUseCase = new CreateDiamond();

    @Test
    void invalidLetterThrowsException() {
        InvalidLetterException thrown = Assertions.assertThrows(InvalidLetterException.class, () -> {
            diamondUseCase.createDiamond('z');
        });

        Assertions.assertEquals("The letter must be between A and Z. " +
                "Your selected letter z is invalid.", thrown.getMessage());
    }

    @Test
    void createDiamondWithOneLetter() {
        String diamond = diamondUseCase.createDiamond('A');
        String expected = "A\n";

        assertEquals(expected, diamond);
    }

    @Test
    void createUpperDiamondWithLeadingSpaces() {
        String diamond = diamondUseCase.createDiamond('B');
        String expected = " A\nB";

        assertTrue(diamond.contains(expected));
    }

    @Test
    void createUpperDiamond() {
        String diamond = diamondUseCase.createDiamond('C');
        String expected = "  A\n B B\nC   C\n";

        assertTrue(diamond.contains(expected));
    }

    @Test
    void createCompleteDiamond() {
        String diamond = diamondUseCase.createDiamond('C');
        String expected = "  A\n B B\nC   C\n B B\n  A\n";

        assertEquals(expected, diamond);
    }
}