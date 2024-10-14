import java.util.Arrays;

public class zerooneknapsack {
    public static int ans(int wt[],int val[],int idx,int W,int dp[][]){
        if(idx==0){
            if(wt[0]<=W){
                return val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[idx][W]!=-1){
            return dp[idx][W];
        }
        int notTake=ans(wt, val, idx-1, W,dp);
        int Take=Integer.MIN_VALUE;
        if(wt[idx]<=W){
            Take=val[idx]+ans(wt, val, idx-1, W-wt[idx],dp);
        }
        return dp[idx][W]=Math.max(notTake, Take);
    }
    public static int tabulation(int wt[],int val[],int W,int dp[][]){
        for(int i=wt[0];i<=W;i++){
            dp[0][i]=val[0];
        }
        for(int indx=1;indx<wt.length;indx++){
            for(int cap=0;cap<=W;cap++){
                int notTake=dp[indx-1][cap];
                int Take=Integer.MIN_VALUE;
                if(wt[indx]<=cap){
                    Take=val[indx]+dp[indx-1][cap-wt[indx]];
                }
                dp[indx][cap]=Math.max(Take, notTake);
            }
        }
        return dp[wt.length-1][W];
    }
    public static int space(int wt[],int val[],int W){
        int prev[] = new int[W + 1];
        int curr[]=new int[W+1];

        // Base Condition: Initialize the first row of the array
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind < wt.length; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }

                // Update the array with the maximum value for the current capacity
                curr[cap] = Math.max(notTaken, taken);
            }
            prev=curr;
        }

        // The result is stored in the last element of the array
        return prev[W];
    }
    public static void main(String[] args) {
        int wt[]={1,2,4,5};
        int val[]={5,4,8,6};
        int dp[][]=new int[3][7];
        int W=5;
        System.out.println(space(wt, val, W));
    }
}
