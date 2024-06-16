package de.codingmak.learning.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public static class CharacterNotFoundException extends NotFoundException {
        public CharacterNotFoundException(String characterName) {
            super("Character not found: " + characterName);
        }
    }

    public static class MovieNotFoundException extends NotFoundException {
        public MovieNotFoundException(String movieName) {
            super("Movie not Found: " + movieName);
        }
    }

    public static class SpellNotFoundException extends NotFoundException {
        public SpellNotFoundException(String spellName) {
            super("Spell not found: " + spellName);
        }
    }

    public static class HouseNotFoundException extends NotFoundException {
        public HouseNotFoundException(String houseName) {
            super("House not found: " +houseName);
        }
    }
}
