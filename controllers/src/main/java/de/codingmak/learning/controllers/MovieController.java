package de.codingmak.learning.controllers;

import de.codingmak.learning.exceptions.MovieNotFoundException;
import de.codingmak.learning.models.Movie;
import de.codingmak.learning.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        List<Movie> movies = movieService.getMovieByReleaseYear(year);
        if (movies.isEmpty()) {
            throw new MovieNotFoundException("No movies found for release year: " + year);
        }
        return movies;

    }

    @GetMapping(params = "name")
    public List<Movie> getMovieByName(@RequestParam(name = "name") String name) {
        return movieService.getMovieByName(name);
    }

}
