package de.codingmak.learning.controllers;

import de.codingmak.learning.models.Spell;
import de.codingmak.learning.services.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
public class SpellController {
    private final SpellService spellService;

    @Autowired
    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping
    public List<Spell> getAllSpells() {
        return spellService.getSpellList();
    }

    @GetMapping(params = "name")
    public List<Spell> getSpellByName(@RequestParam(name = "name") String name) {
        return spellService.getSpellByName(name);
    }

    @GetMapping(params = "type")
    public List<Spell> getSpellByType(@RequestParam(name = "type") String type) {
        return spellService.getSpellByType(type);
    }

    @GetMapping(params = "unforgiven")
    public List<Spell> getUnforgivenSpells(@RequestParam(name = "unforgiven") boolean unforgiven) {
        return spellService.getUnforgivenSpells(unforgiven);
    }
}
