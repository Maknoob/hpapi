
import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.models.House;
import de.codingmak.learning.services.HouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class HouseControllerTest {

    private HouseService houseService;


    @BeforeEach
    public void setUp() {
        houseService = new HouseService();
    }

    @Test
    public void testGetHouseByName_ValidName() {
        List<House> houses = houseService.getHouseByName("Gryffindor");
        assertEquals("Gryffindor", houses.getFirst().getName());
    }

    @Test
    public void testGetHouseByName_InvalidName() {
        assertThrows(NotFoundException.HouseNotFoundException.class, () -> houseService.getHouseByName("invalid"));
    }

    @Test
    public void testGetHouseByMember_ValidMember() {
        List<House> houses = houseService.getHouseByMember("Harry Potter");
        assertEquals("Gryffindor", houses.getFirst().getName());
    }

    @Test
    public void testGetHouseByMember_InvalidMember() {
        assertThrows(NotFoundException.HouseNotFoundException.class, () -> houseService.getHouseByMember("invalid"));
    }

}
