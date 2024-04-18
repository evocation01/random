package main.java.com.example.ManageYourFavouriteFood;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        MyFoodFrame frame = new MyFoodFrame();

        MyFoodCollection collection = new MyFoodCollection();
        collection.addFood(new Pizza("Siciliana", "Pizza", "Italy"));
        collection.addFood(new Pizza("Margherita", "Pizza", "Italy"));
        collection.addFood(new Pizza("Neapolitana", "Pizza", "Italy"));
        collection.addFood(new Pasta("Spaghetti", "pasta", "Italy"));
        collection.addFood(new Pasta("Ravioli", "pasta", "Italy"));
        collection.addFood(new Pasta("Fettuccine", "pasta", "Italy"));
        collection.addFood(new Seafood("Sushi", "Seafood", "Japan"));
        collection.addFood(new Seafood("Bouillabaisse ", "Seafood", "France"));
        collection.addFood(new Seafood("Paella ", "Seafood", "Spain"));
        collection.addFood(new Salad("Caesar", "salad", "Mexico"));
        collection.addFood(new Salad("Cobb", "salad", "U.S."));
        collection.addFood(new Salad("Geotjeori", "salad", "South Korea"));
        collection.addFood(new Sandwich("BLT", "sandwich", "U.S."));
        collection.addFood(new Sandwich("Hamburger", "sandwich", "Germany"));
        collection.addFood(new Sandwich("Banh Mi", "sandwich", "Vietnam"));

        // Can also use search methods here!
        searchingForFood(collection,"Siciliana");
        searchingForFood(collection, "Siciliana", "Pizza");
        searchingForFood(collection, "Siciliana", "Pizza", "Italy");

    }

    public static void searchingForFood(MyFoodCollection collection, String name) {
        Food result = collection.searchFood(name);
        if (result != null) {
            System.out.printf("\nFound the food, named '%s' %n", name);
        } else {
            System.out.println("Food not found. You either mistyped or it doesn't exist in our database.");
        }
    }

    public static void searchingForFood(MyFoodCollection collection, String name, String type) {
        Food result = collection.searchFood(name, type);
        if (result != null) {
            System.out.printf("\nFound the food, named '%s' with type '%s' %n", name, type);
        } else {
            System.out.println("Food not found. You either mistyped or it doesn't exist in our database.");
        }
    }

    public static void searchingForFood(MyFoodCollection collection, String name, String type, String origin) {
        Food result = collection.searchFood(name, type, origin);
        if (result != null) {
            System.out.printf("\nFound the food, named '%s' with type '%s' which has the origin of '%s' %n", name, type, origin);
        } else {
            System.out.println("Food not found. You either mistyped or it doesn't exist in our database.");
        }
    }
    



}
