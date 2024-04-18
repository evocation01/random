package main.java.com.example.pizzaManagement;

import Movie_Management_System.Movie;

public interface MovieManagement {
    void addMovie(Movie movie);
    void removeMovie(String title, String genre);
    Movie searchMovie(String title, String genre);
}
