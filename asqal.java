import java.util.ArrayList;
import java.util.*;
public class asqal {
    // public static boolean monotonic(ArrayList<Integer>list){
    //     boolean inc=true;
    //     boolean dec=true;
    //     for(int i=0;i<list.size()-1;i++){
    //         if(list.get(i)<=list.get(i+1)){
    //             dec=false;
    //         }
    //         if(list.get(i)>=list.get(i+1)){
    //             inc=false;
    //         }
            
    //     }
    //     return inc||dec;
    // }
    public static ArrayList<Integer> lonely(ArrayList<Integer>list){
        Collections.sort(list);
        ArrayList<Integer>newlist=new ArrayList<>();
        for(int i=0;i<list.size()-1;i++){
            int m=list.get(i)+1;
            int n=list.get(i)-1;
            int x=1;
            if(list.get(i)==list.get(i+1)||list.contains(m)||list.contains(n)){
                x=0;
            }
            else{
                x=1;
            }
            if(x==1){
                int y=list.get(i);
                newlist.add(y);
            }
        }
        return newlist;
    }
    public static void main(String args[]){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(10);
        list.add(4);
        list.add(5);
        list.add(3);
        System.out.println(lonely(list));
    }
}
