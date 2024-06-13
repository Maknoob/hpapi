package de.codingmak.learning.models;

import java.util.UUID;

public class Spell {

    private final UUID id;
    private final String name;
    private final String elementType;
    private final String description;
    private final String seenIn;
    private final boolean unforgiven;

    public Spell(String name, String elementType, String description, String seenIn, boolean unforgiven) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.elementType = elementType;
        this.description = description;
        this.seenIn = seenIn;
        this.unforgiven = unforgiven;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getElementType() {
        return elementType;
    }

    public String getDescription() {
        return description;
    }

    public String getSeenIn() {
        return seenIn;
    }

    public boolean isUnforgiven() {
        return unforgiven;
    }
}
