import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        Storage storage = new Storage();
        
        JFrame frame = new JFrame("Pizza Pizzeria");
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel pizzaBase = new JLabel();
        pizzaBase.setBounds((800 / 2) - (260 / 2), (600 / 2) - (260 / 2), 260, 260);
        pizzaBase.setIcon(new ImageIcon("pizzaBase.png"));
        frame.add(pizzaBase);

        JButton oliveButton = new JButton("Olives");
        oliveButton.setBounds(10,10,80,40);
        frame.add(oliveButton);
        oliveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when button is clicked
                System.out.println("Added Olives");
            }
        });

        frame.setVisible(true);
    }
}