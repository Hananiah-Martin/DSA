package Dynamic_Programming;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int n=3,w=10;
        int []profit={5,11,13};
        int []weight={2,4,6};
        int [][]dp=new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<w+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(weight[i-1]<=j){
                    dp[i][j]=Math.max(profit[i-1]+dp[i][j-weight[i-1]],dp[i-1][j]);
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println(dp[n][w]);
    }
}
