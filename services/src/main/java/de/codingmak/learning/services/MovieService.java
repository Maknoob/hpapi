package de.codingmak.learning.services;

import org.springframework.stereotype.Service;

import de.codingmak.learning.models.Movie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final List<Movie> movieList;

    public MovieService() {
        movieList = new ArrayList<>();

        Movie movie1 = new Movie("Harry Potter and the Philosopher's Stone", "1", "In \"Harry Potter and the Sorcerer's Stone,\" young Harry discovers he's a wizard and attends Hogwarts School. There, he makes friends, encounters magical creatures, and faces the dark wizard Voldemort for the first time.", "Daniel Redcliffe, Rupert Grint, Emma Watson, Richard Harris, Maggie Smith, Robbie Coltrane, Alan Rickman, Ian Hart, Tom Felton, Richard Griffiths, Fiona Shaw, Hohn Hurt", "2001", "https://media.harrypotterfanzone.com/philosophers-stone-20-years-of-movie-magic-poster.jpg");
        Movie movie2 = new Movie("Harry Potter and the Chamber of Secrets", "2", "In \"Harry Potter and the Chamber of Secrets,\" Harry returns to Hogwarts for his second year, where a series of mysterious attacks threaten the school. With Ron and Hermione's help, Harry uncovers the truth about the Chamber of Secrets and faces the heir of Slytherin.", "Daniel Redcliffe, Rupert Grint, Emma Watson, Richard Harris, Maggie Smith, Robbie Coltrane, Alan Rickman, Kenneth Branagh, Tom Felton, Richard Griffiths, Fiona Shaw, Jason Isaac, Bonnie Wright, John Cleese", "2002", "https://media.harrypotterfanzone.com/chamber-of-secrets-theatrical-poster-1050x0-c-default.jpg");
        Movie movie3 = new Movie("Harry Potter and the Prisoner of Azkaban", "3", "In \"Harry Potter and the Prisoner of Azkaban,\" Harry learns that the dangerous Sirius Black has escaped from Azkaban and is supposedly after him. As he uncovers the truth, Harry discovers secrets about his past and his connection to Sirius.", "Daniel Radcliffe, Rupert Grint, Emma Watson, Michael Gambon, Maggie Smith, Robbie Coltrane, Alan Rickman, Gary Oldman, David Thewlis, Tom Felton, Richard Griffiths, Fiona Shaw, Julie Walters, Mark Williams, Timothy Spall, Emma Thompson.", "2004", "https://media.harrypotterfanzone.com/prisoner-of-azkaban-theatrical-poster.jpg");
        Movie movie4 = new Movie("Harry Potter and the Goblet of Fire", "4", "In \"Harry Potter and the Goblet of Fire,\" Harry competes in the Triwizard Tournament, facing dangerous challenges alongside students from other wizarding schools. As the tournament unfolds, Harry encounters dark forces, leading to the return of Voldemort.", "Daniel Radcliffe, Rupert Grint, Emma Watson, Michael Gambon, Maggie Smith, Robbie Coltrane, Alan Rickman, Ralph Fiennes, Tom Felton, Brendan Gleeson, Miranda Richardson, Robert Pattinson, Stanislav Ianevski, Clemence Poesy.", "2005", "https://media.harrypotterfanzone.com/goblet-of-fire-theatrical-poster-1050x0-c-default.jpg");
        Movie movie5 = new Movie("Harry Potter and the Order of the Phoenix", "5", "In \"Harry Potter and the Order of the Phoenix,\" Harry returns to Hogwarts and discovers the wizarding community in denial about Voldemort's return. He forms Dumbledore's Army to train fellow students in defense against the dark arts and faces the sinister Dolores Umbridge.", "Daniel Radcliffe, Rupert Grint, Emma Watson, Michael Gambon, Maggie Smith, Robbie Coltrane, Alan Rickman, Ralph Fiennes, Tom Felton, Imelda Staunton, Gary Oldman, Helena Bonham Carter, Bonnie Wright, Evanna Lynch, Matthew Lewis.", "2007", "https://media.harrypotterfanzone.com/order-of-the-phoenix-theatrical-poster-2.jpg");
        Movie movie6 = new Movie("Harry Potter and the Half-Blood Prince", "6", "In \"Harry Potter and the Half-Blood Prince,\" Harry discovers an old potions book belonging to the mysterious Half-Blood Prince. As Voldemort's power grows, Harry and Dumbledore delve into the dark secrets of his past to find a way to defeat him.", "Daniel Radcliffe, Rupert Grint, Emma Watson, Michael Gambon, Maggie Smith, Robbie Coltrane, Alan Rickman, Tom Felton, Jim Broadbent, Helena Bonham Carter, Bonnie Wright, Evanna Lynch, Matthew Lewis, Jessie Cave.", "2009", "https://media.harrypotterfanzone.com/half-blood-prince-theatrical-poster-1050x0-c-default.jpg");
        Movie movie7 = new Movie("Harry Potter and the Deathly Hallows – Part 1", "7-1", "In \"Harry Potter and the Deathly Hallows – Part 1,\" Harry, Ron, and Hermione leave Hogwarts to find and destroy Voldemort's Horcruxes. Their journey is perilous, uncovering dark secrets and facing constant danger from Death Eaters.", "Daniel Radcliffe, Rupert Grint, Emma Watson, Ralph Fiennes, Helena Bonham Carter, Alan Rickman, Tom Felton, Bonnie Wright, Evanna Lynch, Matthew Lewis, Bill Nighy, Rhys Ifans, Jason Isaacs.", "2010", "https://media.harrypotterfanzone.com/deathly-hallows-part-1-theatrical-poster-1050x0-c-default.jpg");
        Movie movie8 = new Movie("Harry Potter and the Deathly Hallows – Part 2", "7-2", "In \"Harry Potter and the Deathly Hallows – Part 2,\" Harry, Ron, and Hermione's quest to destroy Voldemort's Horcruxes leads to the final battle at Hogwarts. The epic showdown between Harry and Voldemort determines the fate of the wizarding world.", "Daniel Radcliffe, Rupert Grint, Emma Watson, Ralph Fiennes, Helena Bonham Carter, Alan Rickman, Tom Felton, Bonnie Wright, Evanna Lynch, Matthew Lewis, Maggie Smith, Michael Gambon, Jason Isaacs, Julie Walters.", "2011", "https://media.harrypotterfanzone.com/deathly-hallows-part-2-it-all-ends-poster-1050x0-c-default.jpg");
        Movie movie9 = new Movie("Harry Potter and the Cursed Child", "8", "\"Harry Potter and the Cursed Child\" is a stage play that follows Harry Potter's middle child, Albus Severus Potter, as he struggles with the weight of his family legacy. The play explores themes of friendship, family, and the complexities of living up to expectations. Albus forms an unlikely friendship with Scorpius Malfoy, and together, they embark on a time-traveling adventure that threatens to alter the past and future.", "Jamie Parker, Noma Dumezweni, Paul Thornley, Poppy Miller, Alex Price, Sam Clemmett, Anthony Boyle.", "2016", "https://upload.wikimedia.org/wikipedia/en/8/87/Cursed_Child_new_poster.jpg");

        movieList.addAll(Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public List<Movie> getMovieByPart(String part) {
        return movieList.stream()
                .filter(movie -> movie.getPart().equals(part))
                .collect(Collectors.toList());
    }

    public List<Movie> getMovieByReleaseYear(String releaseYear) {
        return movieList.stream()
                .filter(movie -> movie.getReleaseYear().equals(releaseYear))
                .collect(Collectors.toList());
    }

    public List<Movie> getMovieByName(String name) {
        return movieList.stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
