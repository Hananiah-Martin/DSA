package Dynamic_Programming;

public class Subset_Difference extends SubsetSum{
    public static void main(String[] args) {
        int []arr={1,6,11,5};
        int k=0;
        for(int x:arr){
            k+=x;
        }
        boolean [][]dp=tabulation(arr,arr.length,k);
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<k+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int ans=Integer.MAX_VALUE;
        //i will traverse through last row
        for(int i=0;i<=k/2;i++){
            if(dp[arr.length][i]){
                ans=Math.min(ans,k-2*i);
            }
        }
        System.out.println(ans);
    }
}
