package Dynamic_Programming;

public class CoinChange extends knapsack{
    public static void main(String[] args) {
        int []arr={1,2,3};
        int v=4;
        int n=arr.length;
        int [][]dp=new int[n+1][v+1];
        for(int i=0;i<n+1;i++){
            //this implies that when we require change of value 0 one solution is empty subset
            dp[i][0]=1;
        }
        for(int i=0;i<v+1;i++){
            dp[0][i]=0;
        }
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<v+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i][j-arr[i-1]]+dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        printDp(dp);
        System.out.println(dp[n][v]);
    }
}
