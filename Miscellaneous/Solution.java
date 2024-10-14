class Solution {
        public static int longestSubarray(int[] nums) {
            int i=0;
            int j=0;
            int ans=0;
            int zeroes=0;
            while(j<nums.length){
                if(nums[j]==0) zeroes++;
                if(zeroes<=1){
                    ans=Math.max(ans,j-i);
                    j++;
                }
                else if(zeroes>1){
                    while(zeroes>1){
                        if(nums[i]==0){
                            zeroes--;
                            i++;
                        }
                        j++;
                    }
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        int []nums={1,1,1};
        System.out.println(longestSubarray(nums));
    }
}