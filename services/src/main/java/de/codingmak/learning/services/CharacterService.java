package de.codingmak.learning.services;

import de.codingmak.learning.exceptions.NotFoundException;
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

        Character harry = new Character(1,
                "Harry Potter", "Human", "Male", "31-07-1980", "1980", 44,
                "Green", "Black", true, true, false,
                "Half-blood", true, "Stag", "Holly, 11\", Phoenix feather",
                "Gryffindor", "Daniel Radcliffe", "URL or path to image"
        );
        Character ron = new Character(2,
                "Ron Weasley", "Human", "Male", "01-03-1980", "1980", 44,
                "Blue", "Red", true, true, false,
                "Pure-blood", true, "Jack Russell Terrier", "Willow, 14\", Unicorn hair",
                "Gryffindor", "Rupert Grint", "URL or path to image"
        );
        Character hermione = new Character(3,
                "Hermione Granger", "Human", "Female", "19-09-1979", "1979", 44,
                "Brown", "Brown", true, true, false,
                "Muggle-born", true, "Otter", "Vine, 10¾\", Dragon heartstring",
                "Gryffindor", "Emma Watson", "URL or path to image"
        );
        Character dumbledore = new Character(4,
                "Albus Dumbledore", "Human", "Male", "1881", "1881", 115,
                "Blue", "Silver (white)", false, false, true,
                "Half-blood", true, "Phoenix", "Elder, 15\", Thestral tail hair",
                "Gryffindor", "Richard Harris / Michael Gambon", "URL or path to image"
        );
        Character snape = new Character(5,
                "Severus Snape", "Human", "Male", "09-01-1960", "1960", 38,
                "Black", "Black", false, false, true,
                "Half-blood", true, "Doe", "Unknown",
                "Slytherin", "Alan Rickman", "URL or path to image"
        );
        Character hagrid = new Character(6,
                "Rubeus Hagrid", "Half-giant", "Male", "06-12-1928", "1928", 95,
                "Black", "Black", true, false, true,
                "Half-giant", true, "None (non-corporeal)", "Oak, 16\", Unknown core",
                "Gryffindor", "Robbie Coltrane", "URL or path to image"
        );

        Character draco = new Character(7,
                "Draco Malfoy", "Human", "Male", "05-06-1980", "1980", 44,
                "Grey", "Blonde", true, true, false,
                "Pure-blood", true, "None (unknown)", "Hawthorn, 10\", Unicorn hair",
                "Slytherin", "Tom Felton", "URL or path to image"
        );
        Character mcgonagall = new Character(8,
                "Minerva McGonagall", "Human", "Female", "04-10-1935", "1935", 89,
                "Green", "Black (grey)", true, false, true,
                "Half-blood", true, "Cat", "Fir, 9½\", Dragon heartstring",
                "Gryffindor", "Maggie Smith", "URL or path to image"
        );
        Character sirius = new Character(9,
                "Sirius Black", "Human", "Male", "03-11-1959", "1959", 36,
                "Grey", "Black", false, true, false,
                "Pure-blood", true, "Dog", "Unknown",
                "Gryffindor", "Gary Oldman", "URL or path to image"
        );
        Character bellatrix = new Character(10,
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
        List<Character> nameList = characterList.stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        if (nameList.isEmpty()) {
            throw new NotFoundException.CharacterNotFoundException(name);
        } else {
            return nameList;
        }
    }

    public List<Character> getCharacterByGender(String gender) {
        return characterList.stream()
                .filter(character -> character.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    public List<Character> getCharacterByAge(int age) {
        List<Character> ageList = characterList.stream()
                .filter(character -> character.getAge() == age)
                .toList();

        if (ageList.isEmpty()) {
            throw new NotFoundException.CharacterNotFoundException(String.valueOf(age));
        } else {
            return ageList;
        }
    }

    public List<Character> getCharacterByHouse(String house) {
        List<Character> houseList = characterList.stream()
                .filter(character -> character.getHouse().equalsIgnoreCase(house))
                .toList();

        if (houseList.isEmpty()) {
            throw new NotFoundException.CharacterNotFoundException(String.valueOf(house));
        } else {
            return houseList;
        }
    }

    public List<Character> getCharacterByAncestry(String ancestry) {
        List<Character> ancestryList = characterList.stream()
                .filter(character -> character.getAncestry().equalsIgnoreCase(ancestry))
                .toList();

        if (ancestryList.isEmpty()) {
            throw new NotFoundException.CharacterNotFoundException(String.valueOf(ancestry));
        } else {
            return ancestryList;
        }
    }
}
