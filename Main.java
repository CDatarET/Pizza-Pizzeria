import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Main{
    public static Storage storage = new Storage();
    public static int initialId = 0;

    public static void addCustomer(int id){
        Random rand = new Random();
        String[] fNames = {"John", "Jane", "Ellen", "Rina", "Gregory", "Hugo", "Miyabi", "Bennett", "Ei", "Victor", "Evelyn", "Joseph", "Chiori", "Wise", "Belle", "Jack", "Ayaka", "Satoru", "Furina", "Clorinde", "Robert", "Barrack", "Donald", "Tsukishiro"};
        String[] lNames = {" Raiden", " Kamisato", " Chevalier", " Chen", " Joestar", " House", " Wilson", " Black", " Tucker", " Doe", " Sebastiane", " Hoshimi", " Yanagi", " Patel", " Speedwagon", " Kamado", " Van Astrea", " Karasuma", " Yoichi", " Cuddy", " Sangonomiya"};
        ArrayList<String> orders = new ArrayList<String>();
        ArrayList<Double> costs = new ArrayList<Double>();

        Customer customer = new Customer(id, fNames[rand.nextInt(fNames.length)] + lNames[rand.nextInt(lNames.length)], "placeholder@gmail.com", "placeholder number", "placeholder address", orders, 0, costs);
        storage.addCustomer(customer);
    }

    public static void main(String[] args){
        System.out.println("Hello World");

        
        int count = 5;
        
        JFrame frame = new JFrame("Pizza Pizzeria");
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel pizzaBase = new JLabel();
        pizzaBase.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        pizzaBase.setIcon(new ImageIcon("pizzaBase.png"));

        JLabel olives = new JLabel();
        olives.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        olives.setIcon(new ImageIcon("olive.png"));

        JLabel mushrooms = new JLabel();
        mushrooms.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        mushrooms.setIcon(new ImageIcon("mushroom.png"));

        JButton mushroomButton = new JButton("Mushrooms");
        mushroomButton.setBounds(10,50,80,40);
        mushroomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Mushrooms");
                mushrooms.setVisible(true);
                frame.repaint();
                //frame.revalidate();
            }
        });

        JButton oliveButton = new JButton("Olives");
        oliveButton.setBounds(10,10,80,40);
        oliveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Olives");
                olives.setVisible(true);
                frame.repaint();
                //frame.revalidate();
            }
        });

        JButton newButton = new JButton("Start");
        newButton.setBounds((800 / 2) - 40, (600 / 2) - 20,80,40);
        frame.add(newButton);
        frame.add(oliveButton);
        oliveButton.setVisible(false);
        frame.add(mushroomButton);
        mushroomButton.setVisible(false);

        frame.add(olives);
        olives.setVisible(false);
        frame.add(mushrooms);
        mushrooms.setVisible(false);
        frame.add(pizzaBase);
        pizzaBase.setVisible(false);

        newButton.addActionListener(new ActionListener() {
            boolean init = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                initialId++;
                if(init){
                    System.out.println("Started");
                    newButton.setBounds(600, 500, 150, 40);
                    newButton.setText("Submit Order");
                    oliveButton.setVisible(true);
                    mushroomButton.setVisible(true);
                    pizzaBase.setVisible(true);
                    //frame.repaint();
                    //frame.revalidate();
                }
                init = false;
                addCustomer(initialId);
            }
        });

        frame.setVisible(true);
    }
}