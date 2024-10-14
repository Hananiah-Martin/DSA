public class NonAdjacentSubsequence extends InBuiltFunctions {
    static int find(int []nums,int i,int []dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i]+find(nums,i+2,dp);
        int nottake=find(nums,i+1,dp);
        return dp[i]=Math.max(take,nottake);
    }
    public static void main(String[] args) {
        int []nums={3,5,9};
        int []dp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=-1;
        }
        int ans=find(nums,0,dp);
        System.out.println(ans);
    }
}
