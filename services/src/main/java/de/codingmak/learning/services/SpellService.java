package de.codingmak.learning.services;

import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.models.Spell;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpellService {
    private final List<Spell> spellList;


    public SpellService() {
        spellList = new ArrayList<>();

        Spell avadaKedavra = new Spell(1,
                "Avada Kedavra",
                "Dark Arts",
                "The Killing Curse; causes instant, painless death to the victim.",
                "Harry Potter and the Goblet of Fire",
                true
        );
        Spell expelliarmus = new Spell(2,
                "Expelliarmus",
                "Charm",
                "Disarming Charm; forces whatever an opponent is holding to fly out of their hand.",
                "Harry Potter and the Chamber of Secrets",
                false
        );
        Spell expectoPatronum = new Spell(3,
                "Expecto Patronum",
                "Charm",
                "Conjures a Patronus, a protective shield that takes the form of an animal.",
                "Harry Potter and the Prisoner of Azkaban",
                false
        );
        Spell wingardiumLeviosa = new Spell(4,
                "Wingardium Leviosa",
                "Charm",
                "Levitation Charm; causes objects to levitate.",
                "Harry Potter and the Philosopher's Stone",
                false
        );
        Spell crucio = new Spell(5,
                "Crucio",
                "Dark Arts",
                "The Cruciatus Curse; inflicts unbearable pain on the victim.",
                "Harry Potter and the Goblet of Fire",
                true
        );
        Spell imperio = new Spell(6,
                "Imperio",
                "Dark Arts",
                "The Imperius Curse; places the victim under the caster's control.",
                "Harry Potter and the Goblet of Fire",
                true
        );
        Spell lumos = new Spell(7,
                "Lumos",
                "Charm",
                "Produces light from the caster's wand.",
                "Harry Potter and the Philosopher's Stone",
                false
        );
        Spell nox = new Spell(8,
                "Nox",
                "Charm",
                "Extinguishes the light from the caster's wand.",
                "Harry Potter and the Philosopher's Stone",
                false
        );
        Spell stupefy = new Spell(9,
                "Stupefy",
                "Charm",
                "Stunning de.codingmak.learning.models.Spell; stuns the target.",
                "Harry Potter and the Goblet of Fire",
                false
        );
        Spell accio = new Spell(10,
                "Accio",
                "Charm",
                "Summoning Charm; summons objects towards the caster.",
                "Harry Potter and the Goblet of Fire",
                false
        );
        Spell aguamenti = new Spell(11,
                "Aguamenti",
                "Charm",
                "Produces a jet of water from the caster's wand.",
                "Harry Potter and the Half-Blood Prince",
                false
        );
        Spell alohomora = new Spell(12,
                "Alohomora",
                "Charm",
                "Unlocks doors and other objects.",
                "Harry Potter and the Philosopher's Stone",
                false
        );

        spellList.addAll(Arrays.asList(avadaKedavra, expelliarmus, expectoPatronum, wingardiumLeviosa, crucio, imperio, lumos, nox, stupefy, accio, aguamenti, alohomora));
    }

    public List<Spell> getSpellList() {
        return spellList;
    }

    public List<Spell> getSpellByName(String name) {

        List<Spell> spellByName = spellList.stream()
                .filter(spell -> spell.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        if (spellByName.isEmpty()) {
            throw new NotFoundException.SpellNotFoundException(name);
        }

        return spellByName;
    }

    public List<Spell> getSpellByType(String type) {

        List<Spell> spellByType = spellList.stream()
                .filter(spell -> spell.getElementType().toLowerCase().contains(type.toLowerCase()))
                .collect(Collectors.toList());

        if (spellByType.isEmpty()) {
            throw new NotFoundException.SpellNotFoundException(type);
        }

        return spellByType;
    }

    public List<Spell> getUnforgivenSpells(boolean unforgiven) {
        return spellList.stream()
                .filter(Spell::isUnforgiven)
                .collect(Collectors.toList());
    }
}
