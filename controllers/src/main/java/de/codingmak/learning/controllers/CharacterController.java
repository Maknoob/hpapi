package de.codingmak.learning.controllers;

import de.codingmak.learning.services.CharacterService;
import de.codingmak.learning.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(params = "id")
    public List<Character> getCharacterById(@RequestParam(name = "id") int id) {
        return characterService.getCharacterByID(id);
    }
}
