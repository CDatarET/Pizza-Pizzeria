import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        Storage storage = new Storage();
        ArrayList<String> orders = new ArrayList<String>();
        orders.add("Cheese, Olive Mushroom");
        orders.add("Jalapeno Mushroom, Olive");
        orders.add("Cheese");
        orders.add("GarlicBreadsticks, Cheese2, Olive Mushroom, Jalapeno BananaPepper Serrano");
        Customer c1 = new Customer(1000001,"John Pizza", "customer@gmail.com", "123-456-7890", "123 Street Street #1234 City, State", orders,205);
        storage.addCustomer(c1);

        System.out.println(storage.getCustomer(1000001).getName());
    }
}