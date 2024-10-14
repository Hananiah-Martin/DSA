package SLIDING_WINDOW;
import java.util.*;
import java.lang.reflect.Array;
import java.util.HashMap;

public class longest_subarray_of_sum_k{
    public static int function(int []arr,int k){
        int i=0,j=0;
        int sum=0,ans=0;
        while(j<arr.length){
            sum+=arr[j];
            if(sum<k){
                j++;
            }
            else if(sum==k){
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else {
                while(sum>k){
                    sum-=arr[i];
                    i++;
                }
                if(sum==k){
                    ans=Math.max(ans,j-i+1);
                }
                j++;
            }
        }
        return ans;
    }
    public static int function_two(int []arr,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        int j=0;
        int ans=0,sum=0;
        while(j<arr.length){
            sum+=arr[j];
            //check if there exists sum-k
            if(map.containsKey(sum-k)){
                ans=Math.max(ans,j-map.get(sum-k));
            }
            if(sum==k){
                ans=Math.max(ans,j+1);
            }
            if(!map.containsKey(sum)){
                map.put(sum,j);
            }
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int []arr={-1,0 , 1 ,1 ,-1 ,-1,0};

        int []h=arr;

        for(int x:h){
            System.out.print(x+" ");
        }
    }
}
