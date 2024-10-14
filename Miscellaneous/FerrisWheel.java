import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        String[] weightsStr = sc.nextLine().split(" ");
        Integer[] weights = new Integer[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(weightsStr[i]);
        }
        Arrays.sort(weights);

        int ans = 0;
        int i = 0;      // left pointer
        int j = n - 1;  // right pointer
        while (i <= j) {
            ans++;  // Increment number of gondolas used
            if (i == j) break;
            // If total weight is too large, move to lighter child
            if (weights[i] + weights[j] > x) {
                j--;
            }
            // Otherwise, we pair the two children and move on
            else {
                i++;
                j--;
            }
        }
        System.out.println(ans);
    }
}