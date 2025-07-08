public class Order{
    public int numPizza = 0;
    int chance = 1;

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
    } 
}