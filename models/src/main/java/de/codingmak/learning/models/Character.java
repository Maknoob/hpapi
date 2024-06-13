package de.codingmak.learning.models;

import java.util.UUID;

public class Character {

    private final UUID id;
    private final String name;
    private final String species;
    private final String gender;
    private final String dateOfBirth;
    private final String yearOfBirth;
    private final int age;
    private final String eyeColor;
    private final String hairColor;
    private final boolean alive;
    private final boolean hogwartsStudent;
    private final boolean hogwartsStaff;
    private final String ancestry;
    private final boolean wizard;
    private final String patronus;
    private final String wand;
    private final String house;
    private final String actor;
    private final String image;

    public Character(String name, String species, String gender, String dateOfBirth, String yearOfBirth, int age, String eyeColor, String hairColor, boolean alive, boolean hogwartsStudent, boolean hogwartsStaff, String ancestry, boolean wizard, String patronus, String wand, String house, String actor, String image) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.age = age;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.alive = alive;
        this.hogwartsStudent = hogwartsStudent;
        this.hogwartsStaff = hogwartsStaff;
        this.ancestry = ancestry;
        this.wizard = wizard;
        this.patronus = patronus;
        this.wand = wand;
        this.house = house;
        this.actor = actor;
        this.image = image;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public int getAge() {
        return age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isHogwartsStudent() {
        return hogwartsStudent;
    }

    public boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public String getAncestry() {
        return ancestry;
    }

    public boolean isWizard() {
        return wizard;
    }

    public String getPatronus() {
        return patronus;
    }

    public String getWand() {
        return wand;
    }

    public String getHouse() {
        return house;
    }

    public String getActor() {
        return actor;
    }

    public String getImage() {
        return image;
    }
}
