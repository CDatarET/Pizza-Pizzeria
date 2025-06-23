import javax.swing.*;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        Storage storage = new Storage();
        
        JFrame frame = new JFrame("Pizza Pizzeria");
        frame.setSize(700,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}