package de.codingmak.learning.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class House {

    private final UUID id;
    private final String name;
    private final String description;
    private final List<String> members;

    public House(String name, String description, HouseMember houseMember) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>(houseMember.getHouseMembers());
    }

    public UUID getId() {
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
