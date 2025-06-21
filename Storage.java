import java.util.HashMap;

public class Storage{
    public HashMap<Integer, Customer> map = new HashMap<>();

    public void addCustomer(Customer customer){
        map.put(customer.getCustomerId(), customer);
    }

    public Customer getCustomer(int id){
        return(map.get(id));
    }
}