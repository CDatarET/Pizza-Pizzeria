public class Pizza {
    private String name;
    private String[] toppings;
    private int cost;
    private int[] tops;
    private Pizza next;

    public Pizza(String name, String[] toppings, int cost, int[] tops, Pizza next) {
        this.name = name;
        this.toppings = toppings;
        this.cost = cost;
        this.tops = tops;
        this.next = next;
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

    // Getter and Setter for tops
    public int[] getTops() {
        return tops;
    }

    public void setTops(int[] tops) {
        this.tops = tops;
    }
}
