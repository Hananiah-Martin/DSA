import java.util.*;
public class stack {
    public static int[] helper(int arr[]){
        int n=arr.length;
        int res[]=new int[n];
        Stack<Integer>s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int count=0;
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                count++;
                s.peek();
            }
            res[i]=count;
            s.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int temp[]={73,74,75,71,69,72,76,73};
        int ans[]=helper(temp);
        for(int j:ans){
            System.out.print(j+" ");
        }
    }
}

