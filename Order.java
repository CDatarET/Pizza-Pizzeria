import java.util.Random;

public class Order{
    public int numPizza = 0;
    int chance = 1;

    public static void shuffle(String[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public Order(){
        while(true){
            double prob = Math.random();
            double check = 1 / Math.sqrt(chance);

            if(prob > check){
                break;
            }
            else{
                chance++;
                numPizza++;
            }

        }

        for(int i = 0; i < numPizza; i++){
            Random rand = new Random();

            boolean custom = rand.nextBoolean();
            custom = true;//remove later
            
            Pizza head = new Pizza("", new String[]{""}, 0, null);
            Pizza tail = null;
            head.addPizza(tail);

            boolean init = true;

            if(custom){
                String name = "Custom";

                String[] toppingChoice = {"Olives", "Mushrooms", "Jalapeno", "Banana Pepper", "Pepperoni", "Basil", "Onions", "Tomatoes", "Bell Peppers"};
                shuffle(toppingChoice);
                int toppingL = (int)(Math.random()*5);

                int cost = 7 + (toppingL * 2);
                String[] toppings = new String[toppingL];

                for(int j = 0; j < toppings.length; j++){
                    toppings[j] = toppingChoice[j];
                }

                Pizza pizza = new Pizza(name, toppings, cost, null);
                Pizza current = head;

                while(current.getNext() != null){
                    current = current.getNext();
                }

                current.addPizza(pizza);

            }
            else{
                //add code later
            }
        }

    } 
}