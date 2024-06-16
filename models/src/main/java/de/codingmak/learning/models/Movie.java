package de.codingmak.learning.models;

import java.util.UUID;

public class Movie {

    private final int id;
    private final String name;
    private final String part;
    private final String description;
    private final String actors;
    private final String releaseYear;
    private final String image;

    public Movie(int id, String name, String part, String description, String actors, String releaseYear, String image) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.part = part;
        this.description = description;
        this.actors = actors;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPart() {
        return part;
    }

    public String getDescription() {
        return description;
    }

    public String getActors() {
        return actors;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getImage() { return image; }
}
