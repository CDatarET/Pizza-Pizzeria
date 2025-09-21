import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.lang.StringBuilder;

public class Main{
    public static Storage storage = new Storage();
    public static int initialId = 0;
    public static int count = 0;
    public static int limit = initialId + 10; //increase limit or remove completely when testing is over

    public static void addCustomer(int id){
        Random rand = new Random();
        String[] fNames = {"John", "Jane", "Ellen", "Rina", "Gregory", "Hugo", "Miyabi", "Bennett", "Ei", "Victor", "Evelyn", "Joseph", "Chiori", "Wise", "Belle", "Jack", "Ayaka", "Satoru", "Furina", "Clorinde", "Robert", "Barrack", "Donald", "Tsukishiro", "Luke", "Anakin", "Samuel", "Giorno"};
        String[] lNames = {" Raiden", " Kamisato", " Chevalier", " Chen", " Joestar", " House", " Wilson", " Black", " Tucker", " Doe", " Sebastiane", " Hoshimi", " Yanagi", " Patel", " Speedwagon", " Kamado", " Van Astrea", " Karasuma", " Yoichi", " Cuddy", " Sangonomiya", " Skywalker", " Windu", " Kenobi"};
        ArrayList<Pizza> orders = new ArrayList<Pizza>();
        ArrayList<Double> costs = new ArrayList<Double>();

        Customer customer = new Customer(id, fNames[rand.nextInt(fNames.length)] + lNames[rand.nextInt(lNames.length)], "placeholder@gmail.com", "placeholder number", "placeholder address", orders, 0, costs);
        storage.addCustomer(customer);
    }

    public static Pizza[] generateOrder(Customer c){
        Random rand = new Random();
        int numPizza = 0;
        int chance = 1;
        
        while(true){
            double prob = Math.random();
            double check = 1 / Math.sqrt(chance);

            if(prob > check){
                break;
            }
            
            chance++;
            numPizza++;
        }

        Pizza[] order = new Pizza[numPizza];
        for(int i = 0; i < numPizza; i++){
            boolean custom = rand.nextBoolean();
            custom = false; //fix later

            if(custom){
                //fix later
            }
            else{
                int numTopping = (int)(Math.random()*5);
                float cost = 7 + (numTopping * 2);

                if(numTopping == 0){
                    Pizza pizza = new Pizza("Plain Cheese", new String[]{}, cost);
                    order[i] = pizza;
                    continue;
                }

                String[] tops = new String[numTopping];
                String[] toppings = {"Olives", "Mushrooms", "Jalapeno", "Banana Pepper", "Pepperoni", "Basil", "Onions", "Tomatoes", "Bell Peppers"};
                for (int j = toppings.length - 1; j > 0; j--) {
                    int k = rand.nextInt(j + 1);
                    String temp = toppings[j];
                    toppings[j] = toppings[k];
                    toppings[k] = temp;
                }

                for(int j = 0; j < numTopping; j++){
                    tops[j] = toppings[j];
                }
                Pizza pizza = new Pizza("", tops, cost);
                order[i] = pizza;
            }
        }
        return(order);
    }

    public static void main(String[] args){
        System.out.println("Hello World");
        
        JFrame frame = new JFrame("Pizza Pizzeria");
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JFrame orderFrame = new JFrame("Customer's Order");
        orderFrame.setSize(300, 500);
        orderFrame.setLayout(null);

        JTextArea orderText = new JTextArea();
        orderText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderText);
        scrollPane.setBounds(10, 10, 260, 440);
        orderFrame.add(scrollPane);

        JLabel customerLabel = new JLabel();
        customerLabel.setBounds(350, 50, 100, 30);
        customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customerLabel.setVerticalAlignment(SwingConstants.CENTER);
        customerLabel.setText("Pizza Pizzeria");
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        customerLabel.setBorder(border);
        frame.add(customerLabel);

        //pizza components
        JLabel pizzaBase = new JLabel();
        pizzaBase.setBounds(400 - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        pizzaBase.setIcon(new ImageIcon("images\\pizzaBase.png"));

        JLabel olives = new JLabel();
        olives.setBounds(400 - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        olives.setIcon(new ImageIcon("images\\olive.png"));

        JLabel mushrooms = new JLabel();
        mushrooms.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        mushrooms.setIcon(new ImageIcon("images\\mushroom.png"));

        JLabel jalapenos = new JLabel();
        jalapenos.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        jalapenos.setIcon(new ImageIcon("images\\jalapeno.png"));

        JLabel bananaPeppers = new JLabel();
        bananaPeppers.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        bananaPeppers.setIcon(new ImageIcon("images\\bananaPepper.png"));

        JLabel pepperoni = new JLabel();
        pepperoni.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        pepperoni.setIcon(new ImageIcon("images\\pepperoni.png"));

        JLabel basil = new JLabel();
        basil.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        basil.setIcon(new ImageIcon("images\\basil.png"));

        JLabel onions = new JLabel();
        onions.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        onions.setIcon(new ImageIcon("images\\onions.png"));

        JLabel tomato = new JLabel();
        tomato.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        tomato.setIcon(new ImageIcon("images\\tomato.png"));
        
        JLabel bellPepper = new JLabel();
        bellPepper.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        bellPepper.setIcon(new ImageIcon("images\\bellPepper.png"));

        //buttons for adding
        JButton oliveButton = new JButton("Olives");
        oliveButton.setBounds(10,10,80,40);
        oliveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Olives");
                olives.setVisible(true);
                frame.repaint();
            }
        });

        JButton mushroomButton = new JButton("Mushrooms");
        mushroomButton.setBounds(10,60,100,40);
        mushroomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Mushrooms");
                mushrooms.setVisible(true);
                frame.repaint();
            }
        });

        JButton jalapenoButton = new JButton("Jalapenos");
        jalapenoButton.setBounds(10,110,100,40);
        jalapenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Jalapenos");
                jalapenos.setVisible(true);
                frame.repaint();
            }
        });

        JButton bananaPepperButton = new JButton("Banana Peppers");
        bananaPepperButton.setBounds(10,160,130,40);
        bananaPepperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Banana Peppers");
                bananaPeppers.setVisible(true);
                frame.repaint();
            }
        });

        JButton pepperoniButton = new JButton("Pepperoni");
        pepperoniButton.setBounds(10,210,100,40);
        pepperoniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Pepperoni");
                pepperoni.setVisible(true);
                frame.repaint();
            }
        });

        JButton basilButton = new JButton("Basil");
        basilButton.setBounds(10,260,80,40);
        basilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Basil");
                basil.setVisible(true);
                frame.repaint();
            }
        });

        JButton onionButton = new JButton("Onions");
        onionButton.setBounds(10,310,80,40);
        onionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Onions");
                onions.setVisible(true);
                frame.repaint();
            }
        });

        JButton tomatoButton = new JButton("Tomatoes");
        tomatoButton.setBounds(10,360,90,40);
        tomatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Tomatoes");
                tomato.setVisible(true);
                frame.repaint();
            }
        });

        JButton bellPepperButton = new JButton("Bell Peppers");
        bellPepperButton.setBounds(10,410,120,40);
        bellPepperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Bell Peppers");
                bellPepper.setVisible(true);
                frame.repaint();
            }
        });

        JButton newButton = new JButton("Start");
        newButton.setBounds((800 / 2) - 40, (600 / 2) - 20,80,40);
        frame.add(newButton);

        //remove buttons
        JButton removeOlive = new JButton("Remove Olives");
        removeOlive.setBounds(800 - 150 - 20,10,150,40);
        removeOlive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Olives");
                olives.setVisible(false);
                frame.repaint();
            }
        });

        JButton removeMushroom = new JButton("Remove Mushrooms");
        removeMushroom.setBounds(800 - 160 - 20,60,160,40);
        removeMushroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Mushrooms");
                mushrooms.setVisible(false);
                frame.repaint();
            }
        });

        JButton removeJalapeno = new JButton("Remove Jalapenos");
        removeJalapeno.setBounds(800 - 150 - 20,110,150,40);
        removeJalapeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Jalapenos");
                jalapenos.setVisible(false);
                frame.repaint();
            }
        });

        JButton removeBananaPepper = new JButton("Remove Banana Peppers");
        removeBananaPepper.setBounds(800 - 180 - 20,160,180,40);
        removeBananaPepper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Banana Peppers");
                bananaPeppers.setVisible(false);
                frame.repaint();
            }
        });

        JButton removePepperoni = new JButton("Remove Pepperoni");
        removePepperoni.setBounds(800 - 150 - 20,210,150,40);
        removePepperoni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Remove Pepperoni");
                pepperoni.setVisible(false);
                frame.repaint();
            }
        });

        JButton removeBasil = new JButton("Remove Basil");
        removeBasil.setBounds(800 - 120 - 20,260,120,40);
        removeBasil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Basil");
                basil.setVisible(false);
                frame.repaint();
            }
        });

        JButton removeOnion = new JButton("Remove Onions");
        removeOnion.setBounds(800 - 20 - 130,310,130,40);
        removeOnion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Onions");
                onions.setVisible(false);
                frame.repaint();
            }
        });

        JButton removeTomato = new JButton("Remove Tomatoes");
        removeTomato.setBounds(800 - 20 - 150,360,150,40);
        removeTomato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Tomatoes");
                tomato.setVisible(false);
                frame.repaint();
            }
        });

        JButton removeBellPepper = new JButton("Remove Bell Peppers");
        removeBellPepper.setBounds(800 - 20 - 180,410,180,40);
        removeBellPepper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Removed Bell Peppers");
                bellPepper.setVisible(false);
                frame.repaint();
            }
        });

        //add buttons
        frame.add(oliveButton);
        oliveButton.setVisible(false);
        frame.add(removeOlive);
        removeOlive.setVisible(false);

        frame.add(mushroomButton);
        mushroomButton.setVisible(false);
        frame.add(removeMushroom);
        removeMushroom.setVisible(false);

        frame.add(jalapenoButton);
        jalapenoButton.setVisible(false);
        frame.add(removeJalapeno);
        removeJalapeno.setVisible(false);

        frame.add(bananaPepperButton);
        bananaPepperButton.setVisible(false);
        frame.add(removeBananaPepper);
        removeBananaPepper.setVisible(false);

        frame.add(pepperoniButton);
        pepperoniButton.setVisible(false);
        frame.add(removePepperoni);
        removePepperoni.setVisible(false);

        frame.add(basilButton);
        basilButton.setVisible(false);
        frame.add(removeBasil);
        removeBasil.setVisible(false);

        frame.add(onionButton);
        onionButton.setVisible(false);
        frame.add(removeOnion);
        removeOnion.setVisible(false);

        frame.add(tomatoButton);
        tomatoButton.setVisible(false);
        frame.add(removeTomato);
        removeTomato.setVisible(false);

        frame.add(bellPepperButton);
        bellPepperButton.setVisible(false);
        frame.add(removeBellPepper);
        removeBellPepper.setVisible(false);

        //add components
        frame.add(olives);
        olives.setVisible(false);

        frame.add(mushrooms);
        mushrooms.setVisible(false);

        frame.add(jalapenos);
        jalapenos.setVisible(false);

        frame.add(bananaPeppers);
        bananaPeppers.setVisible(false);

        frame.add(pepperoni);
        pepperoni.setVisible(false);

        frame.add(basil);
        basil.setVisible(false);

        frame.add(onions);
        onions.setVisible(false);

        frame.add(tomato);
        tomato.setVisible(false);

        frame.add(bellPepper);
        bellPepper.setVisible(false);

        frame.add(pizzaBase);
        pizzaBase.setVisible(false);

        newButton.addActionListener(new ActionListener() {
            boolean init = true;
            StringBuilder sb = new StringBuilder();
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                if(init){
                    System.out.println("Started");
                    newButton.setBounds(600, 500, 150, 40);
                    newButton.setText("Submit Order");
                    customerLabel.setBounds(325, 50, 150, 30);

                    oliveButton.setVisible(true);
                    removeOlive.setVisible(true);

                    mushroomButton.setVisible(true);
                    removeMushroom.setVisible(true);

                    jalapenoButton.setVisible(true);
                    removeJalapeno.setVisible(true);

                    bananaPepperButton.setVisible(true);
                    removeBananaPepper.setVisible(true);

                    pepperoniButton.setVisible(true);
                    removePepperoni.setVisible(true);

                    basilButton.setVisible(true);
                    removeBasil.setVisible(true);

                    onionButton.setVisible(true);
                    removeOnion.setVisible(true);

                    tomatoButton.setVisible(true);
                    removeTomato.setVisible(true);

                    bellPepperButton.setVisible(true);
                    removeBellPepper.setVisible(true);

                    pizzaBase.setVisible(true);

                    frame.repaint();

                    addCustomer(initialId);
                    customerLabel.setText(storage.getCustomer(initialId).name);
                    Pizza[] pizzas = generateOrder(storage.getCustomer(initialId));
                    for(int i = 0; i < pizzas.length; i++){
                        sb.append((i + 1) + ": ");
                        if(pizzas[i].getToppings().length == 0){
                            System.out.println(pizzas[i].getName());
                            sb.append(pizzas[i].getName() + "\n");
                            continue;
                        }

                        for(int j = 0; j < pizzas[i].getToppings().length; j++){
                            if(j == pizzas[i].getToppings().length - 1){
                                System.out.println(pizzas[i].getToppings()[j]);
                                sb.append(pizzas[i].getToppings()[j] + "\n");
                                break;
                            }
                            System.out.print(pizzas[i].getToppings()[j] + ", ");
                            sb.append(pizzas[i].getToppings()[j] + ", ");
                        }
                    }

                    orderFrame.setLocation(frame.getX() + frame.getWidth(), frame.getY());
                    orderFrame.setVisible(true);
                    orderText.setText(sb.toString());
                }
                else{
                    Random rand = new Random();
                    int id = rand.nextInt(initialId, limit);
                    if(storage.exists(id)){
                        System.out.println(storage.getCustomer(id).getName() +" "+id);
                    }
                    else{
                        addCustomer(id);
                        count++;
                    }
                    customerLabel.setText(storage.getCustomer(id).name);

                    Pizza[] pizzas = generateOrder(storage.getCustomer(initialId));
                    for(int i = 0; i < pizzas.length; i++){
                        if(pizzas[i].getToppings().length == 0){
                            System.out.println(pizzas[i].getName());
                            continue;
                        }

                        for(int j = 0; j < pizzas[i].getToppings().length; j++){
                            if(j == pizzas[i].getToppings().length - 1){
                                System.out.println(pizzas[i].getToppings()[j]);
                                break;
                            }
                            System.out.print(pizzas[i].getToppings()[j] + ", ");
                        }
                    }
                }
                //reset pizza base
                olives.setVisible(false);
                mushrooms.setVisible(false);
                jalapenos.setVisible(false);
                bananaPeppers.setVisible(false);
                pepperoni.setVisible(false);
                basil.setVisible(false);
                onions.setVisible(false);
                tomato.setVisible(false);
                bellPepper.setVisible(false);

                init = false;
            }
        });
        frame.setVisible(true);
        
    }
}