import java.util.*;
class Solutions{
    public static int helper(int arr[],int k,int i,int dp[]){
        if(i==arr.length-1){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int minCost=Integer.MAX_VALUE;
        for(int j=i+1;j<=i+k&&j<arr.length;j++){
            int jc=Math.abs(arr[j]-arr[i])+helper(arr,k,j,dp);
            minCost=Math.min(minCost,jc);
        }
        dp[i]=minCost;
        return dp[i];
    }
    public static int minimizeCost(int k, int arr[]) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr,k,0,dp);
        // code here
    }
    public static void main(String[] args) {
        int arr[]={10,30,40,50,20};
        int ans=minimizeCost(3, arr);
        System.out.println(ans);
    }
}