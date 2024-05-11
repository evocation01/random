package main.java.com.example.ManageYourFavouriteFood;

public interface FoodManagement {
    void addFood(Food food);
    void removeFood(String name, String type);
    Food searchFood(String name, String type);
}
