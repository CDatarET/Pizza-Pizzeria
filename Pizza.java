public class Pizza {
    private String name;
    private String[] toppings;
    private int cost;
    private Pizza next;
    private Pizza previous;

    public Pizza(String name, String[] toppings, int cost, Pizza next) {
        this.name = name;
        this.toppings = toppings;
        this.cost = cost;
        this.next = null;
        this.previous = null;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for toppings
    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    // Getter and Setter for cost
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    //Getter for next
    public Pizza getNext(){
        return next;
    }

    //add new pizza
    public void addPizza(Pizza pizza){
        this.next = pizza;
        this.next.previous = this;
    }

    //Getter and setter for previous
    public Pizza getPrev(){
        return previous;
    }

    public void setPrev(Pizza pizza){
        this.previous = pizza;
        pizza.addPizza(this);
    }
}
