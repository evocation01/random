package main.java.com.example.ManageYourFavouriteFood;

public abstract class Food {
    protected String name;
    protected String type;
    protected String origin;

    public Food(String name, String type, String origin) {
        this.name = name;
        this.type = type;
        this.origin = origin;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }

    public String get_origin() {
        return origin;
    }

    public void set_origin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
