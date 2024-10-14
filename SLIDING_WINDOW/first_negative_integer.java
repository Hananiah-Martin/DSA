package SLIDING_WINDOW;

import java.util.ArrayList;

public class first_negative_integer {
    static ArrayList<Integer>final_list=new ArrayList<>();
    static void function(int[] arr, int k){
        int n=arr.length;
        int i=0;
        int j=0;
        ArrayList<Integer>temp_list=new ArrayList<>();
        while (j<n){
            if(arr[j]<0){
                temp_list.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
               //remove calculations
                if(temp_list.isEmpty()){
                    final_list.add(0);
                }
                else{
                    final_list.add(temp_list.get(0));
                    if(arr[i]==temp_list.get(0)) {
                        temp_list.remove(temp_list.get(0));
                    }
                }
                i++;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int []arr={12,-1,8,-15,30,16,28};
        function(arr,3);
        System.out.println(final_list);
    }
}
