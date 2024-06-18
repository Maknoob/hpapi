package de.codingmak.learning.controllers;

import de.codingmak.learning.exceptions.InvalidException;
import de.codingmak.learning.exceptions.NotFoundException;
import de.codingmak.learning.models.Movie;
import de.codingmak.learning.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getMovieList();
    }

    @GetMapping(params = "part")
    public List<Movie> getMovieByPart(@RequestParam(name = "part") String part) {
        return movieService.getMovieByPart(part);

    }

    @GetMapping(params = "year")
    public List<Movie> getMovieByReleaseYear(@RequestParam(name = "year") String year) {
        return movieService.getMovieByReleaseYear(year);
    }

    @GetMapping(params = "name")
    public List<Movie> getMovieByName(@RequestParam(name = "name") String name) {
        return movieService.getMovieByName(name);
    }


    @ExceptionHandler(NotFoundException.MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleMovieNotFoundException(NotFoundException.MovieNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler({InvalidException.InvalidPartException.class, InvalidException.InvalidYearException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidException(InvalidException e) {
        return e.getMessage();
    }

}
