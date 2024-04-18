package main.java.com.example.pizzaManagementTool;


public class Main {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        PizzaOrder collection = new PizzaOrder();
        collection.addPizza(new PizzaPastry("Normal", "Thin", "Thick"));
        collection.addPizza(new PizzaType("Mixed", "Pineapple", "Vegan"));
        collection.addPizza(new PizzaSauce("BBQ", "Ketchup", "Mayonnaise")); 
//ustteki AdventurePizza yi replace all dan degistirdim hata vericek (PizzaType) olarak goruncek
        collection.addPizza(new Drink("Cola", "Ayran", "Water"));

        // Can also use search methods here! Comment kismini da duzenlemedim
//        searchingForPizza(collection,"Die Hard");
//        searchingForPizza(collection, "Die Hard", "Action");
//        searchingForPizza(collection, "Die Hard", "Action", "Bruce Willis");

    }
//bu blocktaki collection ve title basliklarini da degistirebilirsin cok bozarim oraya girersem
    public static void searchingForPizza(PizzaOrder collection, String title) {
        Pizza result = collection.searchPizza(title);
        if (result != null) {
            System.out.printf("Found the Pizza, named '%s' %n", title);
        } else {
            System.out.println("Pizza type not found. You either mistyped or it doesn't exist in our database.");
        }
    }

    public static void searchingForPizza(PizzaOrder collection, String title, String genre) {
        Pizza result = collection.searchPizza(title, genre);
        if (result != null) {
            System.out.printf("Found the pizza, named '%s' with genre '%s' %n", title, genre);
        } else {
            System.out.println("Pizza not found. You either mistyped or it doesn't exist in our database.");
        }
    }

    public static void searchingForPizza(PizzaOrder collection, String title, String genre, String protagonist) {
        Pizza result = collection.searchPizza(title, genre);
        if (result != null) {
            System.out.printf("Found the pizza, named '%s' with genre '%s' which was starred by famous actor '%s' %n", title, genre, protagonist);
        } else {
            System.out.println("Pizza not found. You either mistyped or it doesn't exist in our database.");
        }
    }


}
