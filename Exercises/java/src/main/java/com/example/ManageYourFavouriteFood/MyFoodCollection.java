package main.java.com.example.ManageYourFavouriteFood;

import java.util.ArrayList;
import java.util.List;

public class MyFoodCollection implements FoodManagement {

    private static List<Food> foods;

    MyFoodCollection() {
        foods = new ArrayList<>();
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }


    @Override
    public void removeFood(String name, String type) {
        Food food = searchFood(name, type);
        if(food!=null) {
            foods.remove(food);
        }
    }

    public Food searchFood(String name) {
        for (Food food : foods) {
            if (food.get_name().equalsIgnoreCase(name)) {
                return food;
            }
        }
        return null;
    }
        @Override
    public Food searchFood(String name, String type) {
        for (Food food : foods) {
            if (food.get_name().equalsIgnoreCase(name) && food.get_type().equalsIgnoreCase(type)) {
                return food;
            }
        }
        return null;
    }

    public Food searchFood(String name, String type, String origin) {
        for (Food food : foods) {
            if (food.get_name().equalsIgnoreCase(name) && food.get_type().equalsIgnoreCase(type) && food.get_origin().equalsIgnoreCase(origin)) {
                return food;
            }
        }
        return null;
    }

    public void listFoods () {
        for (Food food : foods) {
            System.out.println(food);
        }
    }

}
