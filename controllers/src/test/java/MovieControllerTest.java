
import de.codingmak.learning.exceptions.InvalidPartException;
import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.models.Movie;
import de.codingmak.learning.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    private MovieService movieService;

    @BeforeEach
    public void setUp() {
    movieService = new MovieService();
    }

    @Test
    public void testGetMovieByPart_ValidPart() {
        List<Movie> movies = movieService.getMovieByPart("1");
        assertEquals(1, movies.size());
        assertEquals("Harry Potter and the Philosopher's Stone", movies.get(0).getName());
    }

    @Test
    public void testGetMovieByPart_InvalidPartFormat() {
        assertThrows(InvalidPartException.class, () -> movieService.getMovieByPart("invalid"));
    }

    @Test
    public void testGetMovieByPart_PartNotFound() {
        assertThrows(NotFoundException.MovieNotFoundException.class, () -> movieService.getMovieByPart("9"));
    }
}
