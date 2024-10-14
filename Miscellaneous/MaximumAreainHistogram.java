import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MaximumAreainHistogram {
    public static int helper(int arr[]){
        Stack<Integer>stack=new Stack<>();
        int max=0;
        int width=1;
        max=arr[0];
        stack.push(arr[0]);
        int count=0;
        for(int i=1;i<arr.length;i++){
            int height=arr[i];
            while(!stack.isEmpty()&&stack.peek()>arr[i]){
                width++;
                count++;
                height=Math.min(height,stack.peek());
                stack.pop();
            }
            max=Math.max(width*height,max);
            for(int j=0;j<=i;j++){
                if(!stack.contains(arr[j])) stack.push(arr[j]);
            }
            width=1;
        }
        return max;
    }
    public static void NGE(int nums1[],int nums2[]){
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer>stack=new Stack<>();
        int n= nums2.length;
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        for(int num:res){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println("hananiah".equals("hananiah"));
    }
}
