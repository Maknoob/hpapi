import de.codingmak.learning.exceptions.SpellNotFoundException;
import de.codingmak.learning.models.Spell;
import de.codingmak.learning.services.SpellService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SpellControllerTest {

    private SpellService spellService;

    @BeforeEach
    public void setUp() {
        this.spellService = new SpellService();
    }

    @Test
    public void testGetSpellByName_ValidName() {
        List<Spell> spells = spellService.getSpellByName("Alohomora");
        assertEquals("Alohomora", spells.getFirst().getName());
    }

    @Test
    public void testGetSpellByName_NameNotFound() {
        assertThrows(SpellNotFoundException.class, () -> spellService.getSpellByName("invalid"));
    }
}
