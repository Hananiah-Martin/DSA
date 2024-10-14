import java.util.ArrayList;
import java.util.Collections;
public class arraylist {
    public static void swap(ArrayList<Integer>list,int indx1,int indx2){
        int temp=list.get(indx1);
        list.set(indx1,list.get(indx2));
        list.set(indx2,temp);
    }
    public static void main(String args[]){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3,76);
        list.get(2);
        list.remove(0);
        list.set(1,15);
        // System.out.println(list.contains(15));
        System.out.println("Before sorting");
        System.out.println(list);
        //printing reverse of arraylist
        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i)+" ");
        // }
        //to find maximum in the array list
        // int max=list.get(0);
        // for(int i=1;i<list.size();i++){
        //     if(list.get(i)>max){
        //         max=list.get(i);
        //     }
        // }
        // System.out.println("Maximum number in the array list is "+ max);
        // swap(list, 2, 3);
        // System.out.println("After swapoing");
        // System.out.println(list);
        // Collections.sort(list);
        Collections.sort(list,Collections.reverseOrder());
        // System.out.println("After sorting");
        // System.out.println(list);
        System.out.println("After sorting in descending order");
        System.out.println(list);

    }
}
