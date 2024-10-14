package Dynamic_Programming;

import java.util.Arrays;

public class SubsetSum extends knapsack{
    public static boolean recursion(int []arr,int k,int index){
        if(index<0) return false;
        if(k==0) return true;
        boolean take=false;
        if(arr[index]<=k){
            take=recursion(arr,k-arr[index],index-1);
        }
        boolean not_take=recursion(arr,k,index-1);
        return take||not_take;
    }
    public static boolean [][]  tabulation(int []arr,int n,int k){
        boolean [][]dp=new boolean[n+1][k+1];
        //here row indicates no of elements and column indicates sum
        //i will traverse through first column and make it as true it is possible to form sum 0
        //which is empty subset
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        // i will traverse through first row which indicates to form a sum which is greater than zero
        // which is false
        for(int j=1;j<k+1;j++){
            dp[0][j]=false;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];

            }
        }
        return dp;
    }


    public static void main(String[] args) {
        int []arr={6,1,2,1};
    }
}
