package Dynamic_Programming;

public class longest_increasing_subsequence {
    public static int answer(int []arr){
        int n=arr.length;
        int[][] dp =new int[n+1][n+1];

        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = dp[ind + 1][prev_index + 1];

                int take = 0;

                if(prev_index == -1 || arr[ind] > arr[prev_index]){

                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][prev_index+1] = Math.max(notTake,take);

            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int []nums={5,9,11,6,2,1,13,15};
        System.out.println(answer(nums));
    }
}
