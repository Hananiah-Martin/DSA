package Dynamic_Programming;

import java.util.Arrays;

public class knapsack {
    public static void printDp(int [][]arr){
        for(int []row:arr){
            for(int x:row){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static void printDp(boolean [][]dp){
        for(boolean []row:dp){
            for(boolean y:row){
                System.out.println(y+" ");
            }
            System.out.println();
        }
    }
    public static int[][] fillDp(int [][]arr){
        for(int []row:dp){
            for(int y:row){
                y=-1;
            }
        }
        return arr;
    }
    //bottom up recursive
    static int [][]dp=new int[6][6];

    static int recursion(int []wt,int []val,int i,int maxWt,int currWt){
        if(i==wt.length) return 0;
        int take=0;
        if(currWt+wt[i]<=maxWt){
            take=val[i]+recursion(wt,val,i+1,maxWt,currWt+wt[i]);
        }
        int nottake=recursion(wt,val,i+1,maxWt,currWt);
        return Math.max(take,nottake);
    }
    //top-down recursive
    static int memoization(int []wt,int []val,int maxWt,int n){
        if(n==0||maxWt==0) return 0;
        if(dp[n][maxWt]!=-1) return dp[n][maxWt];
        int take=0;
        if(wt[n-1]<=maxWt){
            take=val[n-1]+memoization(wt,val,maxWt-wt[n-1],n-1);
        }
        int nottake= memoization(wt,val,maxWt,n-1);
        return dp[n][maxWt]=Math.max(take,nottake);
    }
    static int tabulation(int []wt,int []val,int maxWt){
        int n=wt.length;
        int [][]dp=new int[n+1][maxWt+1];
        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<maxWt+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        //here i denotes number of items so we started with 1
        //and j denotes maximum weight so we started with 1
        for(int i=1;i<n+1;i++){
            for(int j=1;j<maxWt+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        printDp(dp);
        return dp[n][maxWt];
    }
    public static void main(String[] args) {
        int []wt={1,2,4,5};
        int []val={5,4,8,6};
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        int ans=tabulation(wt,val,5);
        System.out.println(ans);
    }

}
