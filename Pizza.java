public class Pizza {
    private String name;
    private String[] toppings;
    private float cost;

    public Pizza(String name, String[] toppings, float cost) {
        this.name = name;
        this.toppings = toppings;
        this.cost = cost;
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
    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}