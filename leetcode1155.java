public class leetcode1155 {
        public static int f(int n, int k, int target) {
            int MOD = 1000000007;
            if (n == 0 && target == 0){
                return 1;
            }
            if (target < n || n * k < target) {
                return 0;
            }
            int res = 0;
            for (int i = 1; i <= k; i++) {
                if (target < i) break;
                res = (res + f(n - 1, k, target - i) % MOD) % MOD;
            }
            
            return res;
        }
        public static void main(String[] args) {
            System.out.println(f(2, 6, 7));
        }
}
