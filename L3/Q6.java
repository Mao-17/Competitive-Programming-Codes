import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Total weight
        int k = scanner.nextInt(); // Number of children for each vertex
        int d = scanner.nextInt(); // Minimum weight for the edge

        long[][] dp = new long[n + 1][2]; // Dynamic programming array

        // Base cases
        dp[0][0] = 1;
        dp[0][1] = 0;

        // Calculate the number of paths
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                if (j < d) {
                    dp[i][0] = (dp[i][0] + dp[i - j][0]) % 1000000007;
                    dp[i][1] = (dp[i][1] + dp[i - j][1]) % 1000000007;
                } else {
                    dp[i][1] = (dp[i][1] + dp[i - j][0] + dp[i - j][1]) % 1000000007;
                }
            }
        }

        // Print the result
        System.out.println(dp[n][1]);

        scanner.close();
    }
}
