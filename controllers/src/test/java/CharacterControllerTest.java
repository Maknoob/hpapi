import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.models.Character;
import de.codingmak.learning.services.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CharacterControllerTest {


    private CharacterService characterService;

    @BeforeEach
    public void setUp() {
        characterService = new CharacterService();
    }

    @Test
    public void TestGetCharacterByName_ValidName() {
        List<Character> characters = characterService.getCharacterByName("harry");
        assertEquals("Harry Potter", characters.getFirst().getName());
    }

    @Test
    public void TestGetCharacterByName_InvalidName() {
        assertThrows(NotFoundException.CharacterNotFoundException.class, () -> characterService.getCharacterByName("invalid"));
    }

    @Test
    public void TestGetCharacterByGender_MaleGender() {
        List<Character> characters = characterService.getCharacterByGender("Male");
        assertEquals(7, characters.size());
        assertEquals("Harry Potter", characters.get(0).getName());
        assertEquals("Ron Weasley", characters.get(1).getName());
        assertEquals("Albus Dumbledore", characters.get(2).getName());
        assertEquals("Severus Snape", characters.get(6).getName());
        assertEquals("Rubeus Hagrid", characters.get(3).getName());
        assertEquals("Draco Malfoy", characters.get(4).getName());
        assertEquals("Sirius Black", characters.get(5).getName());
    }

    @Test
    public void TestGetCharacterByGender_FemaleGender() {
        List<Character> characters = characterService.getCharacterByGender("Female");
        assertEquals(3, characters.size());
        assertEquals("Hermione Granger", characters.get(0).getName());
        assertEquals("Minerva McGonagall", characters.get(1).getName());
        assertEquals("Bellatrix Lestrange", characters.get(2).getName());
    }
}
