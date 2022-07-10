package de.baracs.kata.diamond.exceptions;

public class InvalidLetterException extends RuntimeException {
    public InvalidLetterException(String input) {
        super(String.format("The letter must be between A and Z. Your selected letter %s is invalid.", input));
    }
}
