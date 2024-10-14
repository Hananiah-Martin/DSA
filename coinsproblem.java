import java.util.*;
public class coinsproblem {
     public static void main(String[] args) {
        Integer coins[]={1,2,4,10,20,50,100,500,2000};
        Arrays.sort(coins,Comparator.reverseOrder());
        int count=0;
        int amount=590;
        ArrayList<Integer>new_coins=new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    count++;
                    amount=amount-coins[i];
                    new_coins.add(coins[i]);
                }
            }
        }
        System.out.println(count);
        for(int i=0;i<new_coins.size();i++){
            System.out.print(new_coins.get(i)+" ");
        }
    }
}
