import java.util.Arrays;
import java.util.Collections;
public class insertionsort {
    public static void main(String[] args){
        Integer arr[]={5,4,1,3,2};
        for(int i=1;i<arr.length-1;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0&&arr[prev]>arr[prev+1]){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        //inbuilt function to sort
        Arrays.sort(arr);
        //This reverse order method is used only in primitive data type
        Arrays.sort(arr,Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
