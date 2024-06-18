package de.codingmak.learning.controllers;

import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.services.CharacterService;
import de.codingmak.learning.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAllRoles() {
        return characterService.getCharacterList();
    }

    @GetMapping(params = "name")
    public List<Character> getCharacterByName(@RequestParam(name = "name") String name) {
        return characterService.getCharacterByName(name);
    }

    @GetMapping(params = "gender")
    public List<Character> getCharacterByGender(@RequestParam(name = "gender") String gender) {
        return characterService.getCharacterByGender(gender);
    }

    @GetMapping(params = "age")
    public List<Character> getCharacterByAge (@RequestParam(name = "age") int age) {
        return characterService.getCharacterByAge(age);
    }

    @GetMapping(params = "house")
    public List<Character> getCharacterByHouse(@RequestParam(name = "house") String house) {
        return characterService.getCharacterByHouse(house);
    }

    @GetMapping(params = "ancestry")
    public List<Character> getCharacterByAncestry(@RequestParam(name = "ancestry") String ancestry) {
        return characterService.getCharacterByAncestry(ancestry);
    }

    @ExceptionHandler(NotFoundException.CharacterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCharacterNotFoundException(NotFoundException.CharacterNotFoundException e) {
        return e.getMessage();
    }
}
