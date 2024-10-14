public class leetcode75 {
        public static void sortColors(int[] nums) {
            int n=nums.length;
            int start=0;
            int end=n-1;
            while(start<end){
                if(nums[start]>nums[end]){
                    int temp=nums[end];
                    nums[end]=nums[start];
                    nums[start]=temp;
                    start++;
                    end--;
                }
                end--;
            }
            for(int num:nums){
                System.out.print(num+" ");
            }
        }
    public static void main(String[] args) {
        int nums[]={2,0,2,1,1,0};
        sortColors(nums);
    }
}
