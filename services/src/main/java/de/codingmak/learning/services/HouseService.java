package de.codingmak.learning.services;

import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.models.House;
import de.codingmak.learning.models.HouseMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {

    private final List<House> houseList;

    public HouseService() {
        houseList = new ArrayList<>();

        House gryffindor = new House(1,
                "Gryffindor",
                "Gryffindor, founded by the brave and chivalrous Godric Gryffindor, values courage, daring, nerve, and a strong sense of justice. Its emblematic animal is the lion, and its colors are red and gold. Known for producing many heroic witches and wizards, Gryffindor de.codingmak.learning.models.House fosters a spirit of adventure and resilience.",
                HouseMember.GRYFFINDOR);
        House ravenclaw = new House(2,
                "Ravenclaw",
                "Ravenclaw, founded by the wise and creative Rowena Ravenclaw, values intelligence, learning, wisdom, and wit. Its emblematic animal is the eagle, and its colors are blue and silver. Known for producing many brilliant witches and wizards, Ravenclaw de.codingmak.learning.models.House encourages a quest for knowledge and a love of intellectual challenges.",
                HouseMember.RAVENCLAW);
        House hufflepuff = new House(3,
                "Hufflepuff",
                "Hufflepuff, founded by the kind and fair Helga Hufflepuff, values hard work, loyalty, patience, and dedication. Its emblematic animal is the badger, and its colors are yellow and black. Known for producing many diligent and dependable witches and wizards, Hufflepuff de.codingmak.learning.models.House promotes a strong sense of justice and community.",
                HouseMember.HUFFLEPUFF);
        House slytherin = new House(4,
                "Slytherin",
                "Slytherin, founded by the ambitious and cunning Salazar Slytherin, values resourcefulness, leadership, ambition, and self-preservation. Its emblematic animal is the serpent, and its colors are green and silver. Known for producing many powerful and influential witches and wizards, Slytherin de.codingmak.learning.models.House emphasizes determination and a drive for success.",
                HouseMember.SLYTHERIN);

        houseList.addAll(Arrays.asList(gryffindor, ravenclaw, hufflepuff, slytherin));
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public List<House> getHouseByName(String name) {
        List<House> houseByName = houseList.stream()
                .filter(house -> house.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if (houseByName.isEmpty()) {
            throw new NotFoundException.HouseNotFoundException(name);
        } else {
            return houseByName;
        }
    }

    public List<House> getHouseByMember(String member) {
        List<House> houseByMember = houseList.stream()
                .filter(house -> house.getMembers().stream()
                        .anyMatch(members -> members.toLowerCase().contains(member.toLowerCase())))
                .collect(Collectors.toList());

        if (houseByMember.isEmpty()) {
            throw new NotFoundException.HouseNotFoundException(member);
        } else {
            return houseByMember;
        }
    }
}