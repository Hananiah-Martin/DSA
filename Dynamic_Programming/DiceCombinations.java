public class DiceCombinations {
    static final long MOD = 1000000007;

    // Function to find the number of ways to construct the sum N
    static long solve(long N) {
        // dp[] array such that dp[i] stores the number of ways
        // to construct sum = i
        long[] dp = new long[(int) (N + 1)];

        // Initialize dp[0] = 1 as there is only 1 way to
        // construct sum = 0, that is to not throw any dice at all
        dp[0] = 1;

        // Iterate over all possible sums from 1 to N
        for (int i = 1; i <= N; i++) {
            // Iterate over all the possible values of the last die, that is from 1 to 6
            for (int j = 1; j <= 6 && j <= i; j++) {
                dp[i] = (dp[i] + dp[(int) (i - j)]) % MOD;
            }
        }
        for(Long i:dp){
            System.out.print(i+" ");
        }
        // Return the number of ways to construct sum = N
        return dp[(int) N];
    }
    public static int gcd(int a,int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }

    public static void main(String[] args) {
        // Sample Input
        long N = 4;
        int num=54;
        String str=String.valueOf(num);
        int c=(int)str.charAt(0);
        System.out.println(gcd(2,4));

    }
}

