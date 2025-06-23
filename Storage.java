import java.util.HashMap;

public class Storage{
    public HashMap<Integer, Customer> map = new HashMap<>();

    public void addCustomer(Customer customer){
        map.put(customer.getCustomerId(), customer);
        System.out.println("Added Customer " + map.get(customer.getCustomerId()).getName());
    }

    public Customer getCustomer(int id){
        return(map.get(id));
    }

    public void removeCustomer(int id){
        System.out.println("Removed Customer " + map.get(id).getName());
        map.remove(id);
    }
}