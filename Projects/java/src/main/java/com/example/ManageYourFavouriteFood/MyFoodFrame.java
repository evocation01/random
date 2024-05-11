package main.java.com.example.ManageYourFavouriteFood;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyFoodFrame extends JFrame implements ActionListener {
    MyFoodCollection collection = new MyFoodCollection();
    JButton nameButton;
    JButton ageButton;
    JButton birthPlaceButton;
    JButton currentHomeButton;
    JButton yourIDButton;
    JButton addButton;
    JButton removeButton;
    JButton searchButton1;
    JButton searchButton2;
    JButton searchButton3;
    JButton listButton;
    JButton helpButton;
    JTextArea textArea;
    ImageIcon icon = new ImageIcon("Exercises/java/src/main/java/com/example/ManageYourFavouriteFood/food.jpeg");

String name = "";
int age = 0;
String birthPlace = "";
String currentHomePlace = "";
private boolean validInput = false;


    public MyFoodFrame() {

        try {
            name = JOptionPane.showInputDialog("Enter your name:");
            birthPlace = JOptionPane.showInputDialog("Enter your birthplace:");
            currentHomePlace = JOptionPane.showInputDialog("Enter where you live right now:");
        } catch (Exception e) {
            System.out.print("An error occurred while getting user input.");
            e.printStackTrace();
        }

// We want to create a 'while loop' for this since it's very easy for the user to not write an integer when typing their age.
        while (validInput!=true) {
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age:"));
                if (age<= 0) {
                    throw new NumberFormatException();
                }
                validInput = true;
                } catch (NumberFormatException nfe) {
                System.out.println("Invalid age input. Please enter a valid integer.");
            }

        }


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(new Dimension(500, 500));
        this.setTitle("Food Management System");
        this.setIconImage(icon.getImage());


        // Adding the panels: //
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(new Color(139,0,0));
        panel2.setBackground(new Color(199,21,133));
        panel3.setBackground(new Color(255,69,0));
        panel4.setBackground(new Color(75,0,130));
        panel5.setBackground(new Color(189, 183, 107));

        panel5.setLayout(new BorderLayout());

        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(150, 100));
        panel3.setPreferredSize(new Dimension(150, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);
        this.add(panel5, BorderLayout.CENTER);
        // Panels have been added. //


        addButton = new JButton("Add A Food");
        addButton.addActionListener(this);
        addButton.setMnemonic(KeyEvent.VK_A);

        removeButton = new JButton("Remove A Food");
        removeButton.addActionListener(this);
        removeButton.setMnemonic(KeyEvent.VK_R);

        listButton = new JButton("List all existing foods");
        listButton.addActionListener(this);
        listButton.setMnemonic(KeyEvent.VK_L);

        searchButton1 = new JButton("N-Search"); //Search for a Food using its name
        searchButton1.addActionListener(this);
        searchButton1.setMnemonic(KeyEvent.VK_1);

        searchButton2 = new JButton("NT-Search"); //Search for a Food using its name and type
        searchButton2.addActionListener(this);
        searchButton2.setMnemonic(KeyEvent.VK_2);

        searchButton3 = new JButton("NTO-Search"); //Search for a Food using its name, type and origin
        searchButton3.addActionListener(this);
        searchButton3.setMnemonic(KeyEvent.VK_3);

        nameButton = new JButton("Name");
        nameButton.addActionListener(this);
        nameButton.setMnemonic(KeyEvent.VK_N);

        ageButton = new JButton("Age");
        ageButton.addActionListener(this);
        ageButton.setMnemonic(KeyEvent.VK_G);

        birthPlaceButton = new JButton("Birthplace");
        birthPlaceButton.addActionListener(this);
        birthPlaceButton.setMnemonic(KeyEvent.VK_B);

        currentHomeButton = new JButton("Current home");
        currentHomeButton.addActionListener(this);
        currentHomeButton.setMnemonic(KeyEvent.VK_C);

        helpButton = new JButton("Help");
        helpButton.addActionListener(this);
        helpButton.setMnemonic(KeyEvent.VK_H);

        yourIDButton = new JButton("ID");
        yourIDButton.addActionListener(this);
        yourIDButton.setMnemonic(KeyEvent.VK_I);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Hack", Font.BOLD, 20));
        textArea.setForeground(new Color(0,163,108));

        PrintStream printStream = new PrintStream(new TextAreaOutputStream(textArea));
        System.setOut(printStream);
        JScrollPane scrollPane = new JScrollPane(textArea); // Wrap the text area in a scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Show vertical scroll bar
        panel5.add(scrollPane, BorderLayout.CENTER); // Add the scroll pane to panel5

        panel1.add(nameButton);
        panel1.add(ageButton);
        panel1.add(birthPlaceButton);
        panel1.add(currentHomeButton);
        panel1.add(yourIDButton);
        panel2.add(addButton);
        panel2.add(removeButton);
        panel3.add(searchButton1);
        panel3.add(searchButton2);
        panel3.add(searchButton3);
        panel4.add(listButton);
        panel4.add(helpButton);
        panel5.add(scrollPane);


        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String name = JOptionPane.showInputDialog("\nEnter the name of the food:");
            String type = JOptionPane.showInputDialog("\nPlease enter the type of the food: \nAccepted types: 'Pizza' 'pasta' 'Seafood' 'salad' 'sandwich'");
            type = type.toLowerCase();
            String origin = JOptionPane.showInputDialog("\nPlease enter the origin of the food, if known.");

            switch (type.toLowerCase()) {
                case "pizza":
                    collection.addFood(new Pizza(name, "Pizza", origin));
                    break;
                case "pasta":
                    collection.addFood(new Pasta(name, "Pasta", origin));
                    break;
                case "seafood":
                    collection.addFood(new Seafood(name, "Seafood", origin));
                    break;
                case "salad":
                    collection.addFood(new Salad(name, "Salad", origin));
                    break;
                case "sandwich":
                    collection.addFood(new Sandwich(name, "Sandwich", origin));
                    break;
                default:
                    System.out.println("Not a known type.");
                    break;
            }

        }


        if (e.getSource() == removeButton) {
            String name = JOptionPane.showInputDialog("\nEnter the name of the food:");
            String type = JOptionPane.showInputDialog("\nPlease enter the type of the food: \nAccepted types: 'Pizza' 'pasta' 'Seafood' 'salad' 'sandwich'");
            type = type.toLowerCase();
            System.out.printf("\nRemoving the food with the name %s and type %s", name, type);
            collection.removeFood(name, type);
        }

        if (e.getSource() == searchButton1) {
            String name = JOptionPane.showInputDialog("\nEnter the name of the food:");

            Main.searchingForFood(collection, name);
        }

        if (e.getSource() == searchButton2) {
            String name = JOptionPane.showInputDialog("\nEnter the name of the food:");
            String type = JOptionPane.showInputDialog("\nPlease enter the type of the food: \nAccepted types: 'Pizza' 'pasta' 'Seafood' 'salad' 'sandwich'");
            type = type.toLowerCase();

            Main.searchingForFood(collection, name, type);
        }
        if (e.getSource() == searchButton3) {
            String name = JOptionPane.showInputDialog("\nEnter the name of the food:");
            String type = JOptionPane.showInputDialog("\nPlease enter the type of the food: \nAccepted types: 'Pizza' 'pasta' 'Seafood' 'salad' 'sandwich'");
            type = type.toLowerCase();
            String origin = JOptionPane.showInputDialog("\nPlease enter the origin of the food, if known.");

            Main.searchingForFood(collection, name, type, origin);
        }

        if (e.getSource() == listButton) {
            collection.listFoods();
        }

        if (e.getSource() == nameButton) {
            System.out.print("\nYour name is " + name);
        }
        if (e.getSource() == ageButton) {
            System.out.print("\nYour age is " + age);
        }

        if (e.getSource() == birthPlaceButton) {
            System.out.print("\nYou were born in " + birthPlace);
        }
        if (e.getSource() == currentHomeButton) {
            System.out.print("\nYou are living in " + currentHomePlace);
        }
        if (e.getSource() == yourIDButton) {
            System.out.printf("\nYour name is %s, your age is %d, you were born in %s and you are living in %s", name, age, birthPlace, currentHomePlace);
        }

        if (e.getSource() == helpButton) {
            System.out.print("\nSome information on everything: ");
            System.out.print("\nN: name");
            System.out.print("\nNT: name and type");
            System.out.println("\nNTO: name, type and origin");
            System.out.println("\nRed area gives some basic information.");
            System.out.println("\nPink area let's you add or remove a food.");
            System.out.println("\nPurple area let's you either list all the foods or get some help.");
            System.out.println("\nOrange area let's you add or remove a food.");
            System.out.println("\nYou can also use mnemonics to easily press buttons:");
            System.out.println("\nAdd(Alt+A), Remove(Alt+R), List (ALT+L), Search1 (ALT+1), " +
                               "\nSearch2 (ALT+2), Search3 (ALT+3), name (ALT+N), age (ALT+G), " +
                               "\nbirthPlace(ALT+B), currentHome(ALT+C), help (ALT+H), yourID (ALT+I)");

        }
    }
        class TextAreaOutputStream extends OutputStream {
            private JTextArea textArea;

            public TextAreaOutputStream(JTextArea textArea) {
                this.textArea = textArea;
            }

            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        }

}
