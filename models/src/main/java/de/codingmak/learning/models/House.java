package de.codingmak.learning.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class House {

    private final int id;
    private final String name;
    private final String description;
    private final List<String> members;

    public House(int id, String name, String description, HouseMember houseMember) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>(houseMember.getHouseMembers());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getMembers() {
        return members;
    }
}
