package Pizza_Management_System;

public abstract class Pizza {
    protected String title;
    protected String genre;
    protected String protagonist;

    public Pizza(String title, String genre, String protagonist) {
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
        return "Pizza{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", protagonist='" + protagonist + '\'' +
                '}';
    }
}
