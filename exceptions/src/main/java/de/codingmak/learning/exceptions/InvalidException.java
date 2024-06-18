package de.codingmak.learning.exceptions;

public class InvalidException extends RuntimeException {

    public InvalidException(String message) {
        super(message);
    }

    public static class InvalidPartException extends InvalidException {
        public InvalidPartException(String partNumber) {
            super(partNumber + " is an invalid number.");
        }
    }

    public static class InvalidYearException extends InvalidException {
        public InvalidYearException(String yearNumber) {
            super(yearNumber + " is an invalid number.");
        }
    }
}
