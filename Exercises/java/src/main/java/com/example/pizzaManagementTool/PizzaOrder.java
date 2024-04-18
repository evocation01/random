import java.util.ArrayList;
import java.util.List;

public class PizzaOrder implements PizzaManagement {

    private static List<Pizza> Pizzas;

    PizzaOrder() {
        Pizzas = new ArrayList<>();
    }

    @Override
    public void addPizza(Pizza Pizza) {
        Pizzas.add(Pizza);
    }


    @Override
    public void removePizza(String title, String genre) {
        Pizza Pizza = searchPizza(title, genre);
        if(Pizza!=null) {
            Pizzas.remove(Pizza);
        }
    }

    public Pizza searchPizza(String title) {
        for (Pizza Pizza : Pizzas) {
            if (Pizza.getTitle().equalsIgnoreCase(title)) {
                return Pizza;
            }
        }
        return null;
    }
        @Override
    public Pizza searchPizza(String title, String genre) {
        for (Pizza Pizza : Pizzas) {
            if (Pizza.getTitle().equalsIgnoreCase(title) && Pizza.getGenre().equalsIgnoreCase(genre)) {
                return Pizza;
            }
        }
        return null;
    }

    public Pizza searchPizza(String title, String genre, String protagonist) {
        for (Pizza Pizza : Pizzas) {
            if (Pizza.getTitle().equalsIgnoreCase(title) && Pizza.getGenre().equalsIgnoreCase(genre) && Pizza.getProtagonist().equalsIgnoreCase(protagonist)) {
                return Pizza;
            }
        }
        return null;
    }

    public void listPizzas () {
        for (Pizza Pizza : Pizzas) {
            System.out.println(Pizza);
        }
    }

}
