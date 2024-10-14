import java.util.*;
public class hashmaps {
    public static void majority_element(int arr[]){
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }
        }
        Set<Integer>keys=hm.keySet();
        for (Integer i : keys) {
            if(hm.get(i)>1){
                System.out.print(i);
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={2,3,1,1,2,3,4,1,4,4,5};
        majority_element(arr);
    }
}
