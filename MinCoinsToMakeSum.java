import java.util.*;

public class MinCoinsToMakeSum {
    static final int INF = 1000000000;

    // Function to find the minimum number of coins to make sum X
    static long solve(int N, int X, List<Integer> coins) {
        // dp[] array such that dp[i] stores the minimum number
        // of coins to make sum = i
        long[] dp = new long[X + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // Iterate over all possible sums from 1 to X
        for (int i = 1; i <= X; i++) {
            // Iterate over all coins
            for (int j = 0; j < N; j++) {
                if (coins.get(j) > i || dp[i - coins.get(j)] == INF) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins.get(j)] + 1);
            }
        }

        // If it is possible to make sum = X, return dp[X]
        if (dp[X] != INF) {
            return dp[X];
        }

        // If it is impossible to make sum = X, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Sample Input
        int N = 3, X = 6;
        List<Integer> coins = Arrays.asList(1, 2, 3);

        System.out.println(solve(N, X, coins));
    }
}


