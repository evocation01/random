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

public class MyFrame extends JFrame implements ActionListener {
    PizzaOrder collection = new PizzaOrder();
    JButton nameButton;
    JButton ageButton;
    JButton lastNameButton;
    JButton currentAdressButton;
    JButton yourIDButton;
    JButton addButton;
    JButton removeButton;
    JButton searchButton1;
    JButton searchButton2;
    JButton searchButton3;
    JButton listButton;
    JButton helpButton;
    JTextArea textArea;
    ImageIcon icon = new ImageIcon("C:/Users/hakan/IdeaProjects/ALL/SERIOUS_Projects/Pizza.png");
//Burda dosya adi degisiyo onu sen halledersin

String name = "";
int age = 0;
String lastName = "";
String currentAdress = "";
private boolean validInput = false;


    public MyFrame() {

        try {
            name = JOptionPane.showInputDialog("Enter your name:");
            lastName = JOptionPane.showInputDialog("Enter your last name:");
            currentAdress = JOptionPane.showInputDialog("Enter your adress:");
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
        this.setTitle("Pizza Management Systemw");
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


        addButton = new JButton("Add A Pizza");
        addButton.addActionListener(this);
        addButton.setMnemonic(KeyEvent.VK_A);

        removeButton = new JButton("Remove A Pizza");
        removeButton.addActionListener(this);
        removeButton.setMnemonic(KeyEvent.VK_R);

        listButton = new JButton("List all existing Pizzas");
        listButton.addActionListener(this);
        listButton.setMnemonic(KeyEvent.VK_L);

        searchButton1 = new JButton("T-Search"); //Search for a Pizza using its title
        searchButton1.addActionListener(this);
        searchButton1.setMnemonic(KeyEvent.VK_1);

        searchButton2 = new JButton("TG-Search"); //Search for a Pizza using its title and genre
        searchButton2.addActionListener(this);
        searchButton2.setMnemonic(KeyEvent.VK_2);

        searchButton3 = new JButton("TGP-Search"); //Search for a Pizza using its title, genre and protagonist
        searchButton3.addActionListener(this);
        searchButton3.setMnemonic(KeyEvent.VK_3);

        nameButton = new JButton("Name");
        nameButton.addActionListener(this);
        nameButton.setMnemonic(KeyEvent.VK_N);

        ageButton = new JButton("Age");
        ageButton.addActionListener(this);
        ageButton.setMnemonic(KeyEvent.VK_G);

        lastNameButton = new JButton("LastName");
        lastNameButton.addActionListener(this);
        lastNameButton.setMnemonic(KeyEvent.VK_B);

        currentAdressButton = new JButton("Current home");
        currentAdressButton.addActionListener(this);
        currentAdressButton.setMnemonic(KeyEvent.VK_C);

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
        panel1.add(lastNameButton);
        panel1.add(currentAdressButton);
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
//BURALARI ANLAMADIM KODA NASI BI ETKISI VAR
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String title = JOptionPane.showInputDialog("\nEnter the name of the Pizza:");
            String genre = JOptionPane.showInputDialog("\nPlease enter the genre of the Pizza: \nAccepted genres: 'action' 'adventure' 'scifi' 'drama' 'comedy'");
            genre = genre.toLowerCase();
            String protagonist = JOptionPane.showInputDialog("\nPlease enter the name of the protagonist of the Pizza, if known.");

            switch (genre) {
                case "action":
                    collection.addPizza(new PizzaPastry(title, "Action", protagonist));
                    break;
                case "adventure":
                    collection.addPizza(new PizzaType(title, "Adventure", protagonist));
                    break;
                case "scifi":
                    collection.addPizza(new SciFiPizza(title, "SciFi", protagonist));
                    break;
                case "drama":
                    collection.addPizza(new DramaPizza(title, "Drama", protagonist));
                    break;
                case "comedy":
                    collection.addPizza(new ComedyPizza("EE", "Comedy", protagonist));
                    break;
                default:
                    System.out.println("Not a known genre.");
                    break;
            }

        }


        if (e.getSource() == removeButton) {
            String title = JOptionPane.showInputDialog("\nEnter the name of the Pizza:");
            String genre = JOptionPane.showInputDialog("\nPlease enter the genre of the Pizza: \nAccepted genres: 'action' 'adventure' 'scifi' 'drama' 'comedy'");
            genre = genre.toLowerCase();
            System.out.printf("\nRemoving the Pizza with the title %s and genre %s", title, genre);
            collection.removePizza(title, genre);
        }

        if (e.getSource() == searchButton1) {
            String title = JOptionPane.showInputDialog("Enter the name of the Pizza:");

            Main.searchingForPizza(collection, title);
        }

        if (e.getSource() == searchButton2) {
            String title = JOptionPane.showInputDialog("\nEnter the name of the Pizza:");
            String genre = JOptionPane.showInputDialog("\nPlease enter the genre of the Pizza: \nAccepted genres: 'action' 'adventure' 'scifi' 'drama' 'comedy'");
            genre = genre.toLowerCase();

            Main.searchingForPizza(collection, title, genre);
        }
        if (e.getSource() == searchButton3) {
            String title = JOptionPane.showInputDialog("\nEnter the name of the Pizza:");
            String genre = JOptionPane.showInputDialog("\nPlease enter the genre of the Pizza: \nAccepted genres: 'action' 'adventure' 'scifi' 'drama' 'comedy'");
            genre = genre.toLowerCase();
            String protagonist = JOptionPane.showInputDialog("\nPlease enter the name of the protagonist of the Pizza, if known.");

            Main.searchingForPizza(collection, title, genre, protagonist);
        }

        if (e.getSource() == listButton) {
            collection.listPizzas();
        }

        if (e.getSource() == nameButton) {
            System.out.print("\nYour name is " + name);
        }
        if (e.getSource() == ageButton) {
            System.out.print("\nYour age is " + age);
        }

        if (e.getSource() == lastNameButton) {
            System.out.print("\nYour last name is" + lastName);
        }
        if (e.getSource() == currentAdressButton) {
            System.out.print("\nYour address is" + currentAdress);
        }
        if (e.getSource() == yourIDButton) {
            System.out.printf("\nYour name is %s, your age is %d, your last name is %s and your address is %s", name, age, lastName, currentAdress);
        }

        if (e.getSource() == helpButton) {
            System.out.print("\nSome information on everything: ");
            System.out.print("\nT: Title");
            System.out.print("\nTG: Title and Genre");
            System.out.println("\nTGP: Title, Genre and Protagonist");
            System.out.println("\nRed area gives some basic information.");
            System.out.println("\nPink area let's you add or remove a Pizza.");
            System.out.println("\nPurple area let's you either list all the Pizzas or get some help.");
            System.out.println("\nOrange area let's you add or remove a Pizza.");
            System.out.println("\nYou can also use mnemonics to easily press buttons:");
            System.out.println("\nAdd(Alt+A), Remove(Alt+R), List (ALT+L), Search1 (ALT+1), " +
                               "\nSearch2 (ALT+2), Search3 (ALT+3), name (ALT+N), age (ALT+G), " +
                               "\nlastName(ALT+B), currentHome(ALT+C), help (ALT+H), yourID (ALT+I)");

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
