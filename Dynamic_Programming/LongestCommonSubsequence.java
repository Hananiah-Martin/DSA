package Dynamic_Programming;
import java.util.*;
public class LongestCommonSubsequence extends knapsack{
    static int recursive(String s1,String s2,int n,int m){
        //base case
        if(n==0||m==0) return 0;
        int match=0;
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            match=1+recursive(s1,s2,n-1,m-1);
        }
        int notmatch=Math.max(recursive(s1,s2,n-1,m),recursive(s1,s2,n,m-1));
        return Math.max(match,notmatch);
    }
    static int memoization(String s1,String s2,int n,int m,int [][]dp){
        if(n==0||m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        int match=0;
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            match=1+memoization(s1,s2,n-1,m-1,dp);
        }
        int notmatch=Math.max(memoization(s1,s2,n-1,m,dp),memoization(s1,s2,n,m-1,dp));
        return dp[n][m]=Math.max(match,notmatch);
    }
    static int tabulation(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int [][]dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        printDp(dp);
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1="abcdgh";
        String s2="abedfhr";
        int n=s1.length();
        int m=s2.length();
        int [][]dp=new int[n+1][m+1];
        for(int[] row :dp){
            Arrays.fill(row,-1);
        }
        int ans=tabulation(s1,s2);
        System.out.println(ans);
    }
}
