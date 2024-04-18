package main.java.com.example.pizzaManagement;

import Movie_Management_System.ActionMovie;
import Movie_Management_System.AdventureMovie;
import Movie_Management_System.Movie;
import Movie_Management_System.MovieCollection;
import Movie_Management_System.SciFiMovie;
import main.java.com.example.pizzaManagementTool.MyFrame;

public class Main {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        MovieCollection collection = new MovieCollection();
        collection.addMovie(new ActionMovie("Die Hard", "Action", "Bruce Willis"));
        collection.addMovie(new AdventureMovie("Night at the Museum", "Adventure", "Ben Stiller"));
        collection.addMovie(new AdventureMovie("Lord of the Rings", "Adventure", "Ian McKellen"));
        collection.addMovie(new SciFiMovie("Interstellar", "SciFi", "Anne Hathaway"));

        // Can also use search methods here!
//        searchingForMovie(collection,"Die Hard");
//        searchingForMovie(collection, "Die Hard", "Action");
//        searchingForMovie(collection, "Die Hard", "Action", "Bruce Willis");

    }

    public static void searchingForMovie(MovieCollection collection, String title) {
        Movie result = collection.searchMovie(title);
        if (result != null) {
            System.out.printf("Found the movie, named '%s' %n", title);
        } else {
            System.out.println("Movie not found. You either mistyped or it doesn't exist in our database.");
        }
    }

    public static void searchingForMovie(MovieCollection collection, String title, String genre) {
        Movie result = collection.searchMovie(title, genre);
        if (result != null) {
            System.out.printf("Found the movie, named '%s' with genre '%s' %n", title, genre);
        } else {
            System.out.println("Movie not found. You either mistyped or it doesn't exist in our database.");
        }
    }

    public static void searchingForMovie(MovieCollection collection, String title, String genre, String protagonist) {
        Movie result = collection.searchMovie(title, genre);
        if (result != null) {
            System.out.printf("Found the movie, named '%s' with genre '%s' which was starred by famous actor '%s' %n", title, genre, protagonist);
        } else {
            System.out.println("Movie not found. You either mistyped or it doesn't exist in our database.");
        }
    }


}
