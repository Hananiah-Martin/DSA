import java.util.Arrays;

public class countsubsetswithsumk {
    public static int CountSubsets(int index,int sum,int arr[],int dp[][]){
        if(index==0){
            if(arr[0]==sum){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(sum==0){
            return 1;
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum];
        }
        int notTake=CountSubsets(index-1, sum,arr,dp);
        int Take=0;
        if(arr[index]<=sum){
            Take=CountSubsets(index-1, sum-arr[index], arr,dp);
        }
        return dp[index][sum]=Take+notTake;
    }
    public static void main(String[] args) {
        int arr[]={1,2,2,3};
        int sum=3;
        int n=arr.length;
        int dp[][]=new int[n][sum+1];
        for(int row[]:dp){
            Arrays.fill(row, -1);
        }
        System.out.println(CountSubsets(n-1, sum, arr, dp));
    }
}
