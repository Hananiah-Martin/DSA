import java.util.ArrayList;
import java.util.Arrays;

public class testing {
    static int max=Integer.MIN_VALUE;
    public static int maxProduct(int[] nums,int i) {
        if(i==0){
            if(nums[i]!=0){
                return nums[0];
            }
        }
        
        int take=nums[i]*maxProduct(nums,i-1);
        int notake=maxProduct(nums, i-1);
        return Math.max(take,notake);
    }
    public static void main(String[] args) {
        int nums[] = {2,3,-2,4};
      System.out.println(maxProduct(nums, 3));
    }
}
