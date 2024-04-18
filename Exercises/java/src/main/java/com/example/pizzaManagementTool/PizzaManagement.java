public interface PizzaManagement {
    void addPizza(Pizza Pizza);
    void removePizza(String title, String genre);
    Pizza searchPizza(String title, String genre);
}
