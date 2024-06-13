package de.codingmak.learning.services;

import org.springframework.stereotype.Service;
import de.codingmak.learning.models.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    private final List<Character> characterList;


    public CharacterService() {
        characterList = new ArrayList<>();

        Character harry = new Character(
                "Harry Potter", "Human", "Male", "31-07-1980", "1980", 44,
                "Green", "Black", true, true, false,
                "Half-blood", true, "Stag", "Holly, 11\", Phoenix feather",
                "Gryffindor", "Daniel Radcliffe", "URL or path to image"
        );
        Character ron = new Character(
                "Ron Weasley", "Human", "Male", "01-03-1980", "1980", 44,
                "Blue", "Red", true, true, false,
                "Pure-blood", true, "Jack Russell Terrier", "Willow, 14\", Unicorn hair",
                "Gryffindor", "Rupert Grint", "URL or path to image"
        );
        Character hermione = new Character(
                "Hermione Granger", "Human", "Female", "19-09-1979", "1979", 44,
                "Brown", "Brown", true, true, false,
                "Muggle-born", true, "Otter", "Vine, 10¾\", Dragon heartstring",
                "Gryffindor", "Emma Watson", "URL or path to image"
        );
        Character dumbledore = new Character(
                "Albus Dumbledore", "Human", "Male", "1881", "1881", 115,
                "Blue", "Silver (white)", false, false, true,
                "Half-blood", true, "Phoenix", "Elder, 15\", Thestral tail hair",
                "Gryffindor", "Richard Harris / Michael Gambon", "URL or path to image"
        );
        Character snape = new Character(
                "Severus Snape", "Human", "Male", "09-01-1960", "1960", 38,
                "Black", "Black", false, true, true,
                "Half-blood", true, "Doe", "Unknown",
                "Slytherin", "Alan Rickman", "URL or path to image"
        );
        Character hagrid = new Character(
                "Rubeus Hagrid", "Half-giant", "Male", "06-12-1928", "1928", 95,
                "Black", "Black", true, true, true,
                "Half-giant", true, "None (non-corporeal)", "Oak, 16\", Unknown core",
                "Gryffindor", "Robbie Coltrane", "URL or path to image"
        );

        Character draco = new Character(
                "Draco Malfoy", "Human", "Male", "05-06-1980", "1980", 44,
                "Grey", "Blonde", true, true, false,
                "Pure-blood", true, "None (unknown)", "Hawthorn, 10\", Unicorn hair",
                "Slytherin", "Tom Felton", "URL or path to image"
        );
        Character mcgonagall = new Character(
                "Minerva McGonagall", "Human", "Female", "04-10-1935", "1935", 89,
                "Green", "Black (grey)", true, true, true,
                "Half-blood", true, "Cat", "Fir, 9½\", Dragon heartstring",
                "Gryffindor", "Maggie Smith", "URL or path to image"
        );
        Character sirius = new Character(
                "Sirius Black", "Human", "Male", "03-11-1959", "1959", 36,
                "Grey", "Black", false, true, false,
                "Pure-blood", true, "Dog", "Unknown",
                "Gryffindor", "Gary Oldman", "URL or path to image"
        );
        Character bellatrix = new Character(
                "Bellatrix Lestrange", "Human", "Female", "1951", "1951", 47,
                "Dark", "Black", false, true, false,
                "Pure-blood", true, "None (unknown)", "Walnut, 12¾\", Dragon heartstring",
                "Slytherin", "Helena Bonham Carter", "URL or path to image"
        );

        characterList.addAll(Arrays.asList(harry, ron, hermione, dumbledore, hagrid, draco, sirius, mcgonagall, bellatrix, snape));
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public List<Character> getCharacterByName(String name) {
        return characterList.stream()
                .filter(character -> character.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Character> getCharacterByGender(String gender) {
        return characterList.stream()
                .filter(character -> character.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    public List<Character> getCharacterByAge(int age) {
        return characterList.stream()
                .filter(character -> character.getAge() == age)
                .collect(Collectors.toList());
    }

    public List<Character> getCharacterByHouse(String house) {
        return characterList.stream()
                .filter(character -> character.getHouse().equalsIgnoreCase(house))
                .collect(Collectors.toList());
    }
}
