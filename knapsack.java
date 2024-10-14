public class knapsack {
    public static int knapsacks(int wt[],int val[],int w,int i){
        //base condition->it is about changing parameters and least possible value
        if(w==0||i==0) return 0;
        if(wt[i]<=w){
            return Math.max(val[i]+knapsacks(wt,val,w-wt[i],i-1),knapsacks(wt,val,w,i-1));
        }
        else return knapsacks(wt,val,w,i-1);
    }
    public static int tabulation(int wt[],int val[],int w){
        int n=wt.length;       
         //in this example n represents no of items and not the
        //index
        int dp[][]=new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<w+1;i++){
            dp[0][i]=0;
        }
        //i->represents the no of items
        //j->represtns the maximum weight knapsack can take
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                //checking if there is capcacity to take
                if(wt[i-1]<=j){
                    //if there is capacity i can take it or ignore it
                    // i will take maximum of both the cases
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                //if we cannot take answer will be same as before.
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int wt[]={1,3,4,5};
        int val[]={1,4,5,7};
        int w=7;
        int n=wt.length;
        System.out.println(knapsacks(wt,val,w,n-1));
        System.out.println(tabulation(wt,val,w));
    }
}
