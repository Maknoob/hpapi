package de.codingmak.learning.exceptions;

public class SpellNotFoundException extends RuntimeException{

    public SpellNotFoundException(String message) {
        super(message);
    }
}
