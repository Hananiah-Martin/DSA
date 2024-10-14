class Solution {
    public static int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid==nums.length-1){
                return mid;
            }
            else{
                 if(nums[mid]>nums[mid+1]){
                    return mid;
                }
                else if(nums[mid]<nums[mid+1]){
                    start=mid+1;
                }
            }
           
        }
        return -1;
    }
    public static void main(String args[]){
        int nums[]={6,5,4,3,2,3,2};
        System.out.println(findPeakElement(nums));
    }
}