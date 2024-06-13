package de.codingmak.learning.models;

import java.util.Arrays;
import java.util.List;

public enum HouseMember {
    GRYFFINDOR(Arrays.asList(
            "Harry Potter", "Hermione Granger", "Ron Weasley",
            "Neville Longbottom", "Ginny Weasley", "Fred Weasley",
            "George Weasley", "Percy Weasley", "Angelina Johnson",
            "Katie Bell", "Dean Thomas"
    )),
    HUFFLEPUFF(Arrays.asList(
            "Cedric Diggory", "Nymphadora Tonks", "Pomona Sprout",
            "Hannah Abbott", "Susan Bones", "Ernie Macmillan",
            "Justin Finch-Fletchley", "Zacharias Smith", "Leanne",
            "Eleanor Branstone"
    )),
    RAVENCLAW(Arrays.asList(
            "Luna Lovegood", "Cho Chang", "Padma Patil",
            "Terry Boot", "Michael Corner", "Anthony Goldstein",
            "Penelope Clearwater", "Marcus Belby", "Marietta Edgecombe",
            "Roger Davies"
    )),
    SLYTHERIN(Arrays.asList(
            "Draco Malfoy", "Severus Snape", "Bellatrix Lestrange",
            "Tom Riddle", "Narcissa Malfoy", "Lucius Malfoy",
            "Gregory Goyle", "Vincent Crabbe", "Pansy Parkinson",
            "Blaise Zabini"
    ));

    private final List<String> houseMembers;

    HouseMember(List<String> houseMembers) {
        this.houseMembers = houseMembers;
    }

    public List<String> getHouseMembers() {
        return houseMembers;
    }
}
