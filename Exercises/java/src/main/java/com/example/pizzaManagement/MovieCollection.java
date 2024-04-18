package main.java.com.example.pizzaManagement;

import java.util.ArrayList;
import java.util.List;

import Movie_Management_System.Movie;
import Movie_Management_System.MovieManagement;

public class MovieCollection implements MovieManagement {

    private static List<Movie> movies;

    MovieCollection() {
        movies = new ArrayList<>();
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }


    @Override
    public void removeMovie(String title, String genre) {
        Movie movie = searchMovie(title, genre);
        if(movie!=null) {
            movies.remove(movie);
        }
    }

    public Movie searchMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
        @Override
    public Movie searchMovie(String title, String genre) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title) && movie.getGenre().equalsIgnoreCase(genre)) {
                return movie;
            }
        }
        return null;
    }

    public Movie searchMovie(String title, String genre, String protagonist) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title) && movie.getGenre().equalsIgnoreCase(genre) && movie.getProtagonist().equalsIgnoreCase(protagonist)) {
                return movie;
            }
        }
        return null;
    }

    public void listMovies () {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

}
