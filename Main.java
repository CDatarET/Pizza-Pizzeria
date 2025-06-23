import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        Storage storage = new Storage();

        ArrayList<String> orders = new ArrayList<String>();
        orders.add("Small Cheese1, Small Olive Mushroom1");
        orders.add("Small Jalapeno Mushroom1, Small Olive1");
        orders.add("Small Cheese1");
        orders.add("N GarlicBreadsticks1, Large Cheese2, Large Olive Mushroom1, Large Jalapeno BananaPepper Serrano1");

        ArrayList<Double> costs = new ArrayList<Double>();
        costs.add(14.50);
        costs.add(15.50);
        costs.add(7.00);
        costs.add(85.00);

        Customer c1 = new Customer(1000001,"John Pizza", "customer@gmail.com", "123-456-7890", "123 Street Street #1234 City, State", orders, 290, costs);
        storage.addCustomer(c1);

        System.out.print(storage.getCustomer(1000001).getName() + " had ");
        System.out.println(storage.getCustomer(1000001).getPreviousOrders() + " as their last orders");
    }
}