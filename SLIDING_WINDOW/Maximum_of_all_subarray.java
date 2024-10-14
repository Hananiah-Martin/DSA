package SLIDING_WINDOW;

import com.sun.source.tree.Tree;

import java.util.*;

public class Maximum_of_all_subarray {
    static ArrayList<Integer>list=new ArrayList<>();
    public static void function(int []arr,int k){
        TreeMap<Integer,Integer>map=new TreeMap<>(Collections.reverseOrder());
        int i=0,j=0;
        int n=arr.length;
        while(j<n){
            System.out.println(map);
            //calculations
            map.put(arr[j],j);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                //finding the answer
                list.add(map.firstKey());
                //removing calculations
                map.remove(arr[i]);
                i++;
                j++;
            }
        }
    }
    static int helper(int a[],int totalreward,int i){
        if(i<0) return 0;
        int take=0;
        if(a[i]>totalreward){
            take+=a[i]+helper(a,totalreward+a[i],i-1);
        }
        int nottake=helper(a,totalreward,i-1);
        return Math.max(take,nottake);
    }
    public static void main(String[] args) {
        int []arr={3,-3,-1,-4};
        int k=6,n=5;
        int index=0;
        boolean reverse=false;
        for(int i=0;i<k;i++){
            if(i!=0&&(i)%n-1==0){
                reverse=!reverse;
            }
            if(reverse){
                index--;
            }
            else index++;
        }
        int []b={1,1,3,3};
        int y=helper(b,0,b.length-1);
        System.out.println(y);
    }
}
