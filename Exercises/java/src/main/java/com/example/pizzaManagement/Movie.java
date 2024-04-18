package main.java.com.example.pizzaManagement;

public abstract class Movie {
    protected String title;
    protected String genre;
    protected String protagonist;

    public Movie(String title, String genre, String protagonist) {
        this.title = title;
        this.genre = genre;
        this.protagonist = protagonist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", protagonist='" + protagonist + '\'' +
                '}';
    }
}
