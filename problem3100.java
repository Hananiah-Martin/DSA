public class problem3100 {
    public static void main(String[] args) {
        int numBottles = 10, numExchange = 3;
        int emptyBottles=numBottles;
        int bottlesDrunk=numBottles;
        int fullBottles=0;
        while(true){
            if(fullBottles+emptyBottles<numExchange){
                break;
            }
            else{
                if(emptyBottles>=numExchange){
                    fullBottles++;
                    emptyBottles-=numExchange;
                    numExchange++;
                }
                else if(fullBottles+emptyBottles==numExchange){
                    bottlesDrunk+=fullBottles;
                    emptyBottles+=fullBottles;
                    fullBottles=0;
                }
            }
            
        }
        System.out.println(bottlesDrunk+=fullBottles);
    }
}
