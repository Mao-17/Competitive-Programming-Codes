import java.util.Scanner;
import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] capacities = new int[n];
        for (int i = 0; i < n; i++) {
            capacities[i] = sc.nextInt();
        }
        System.out.println(countWays(capacities, m));
    }

    public static int countWays(int[] arr, int M) {
        int N = arr.length;
        int[][] dp = new int[N + 1][M + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for (int j = 0; j <= M; j++) {
                for (int k = 1; k <= arr[i - 1] && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        return dp[N][M] % 100000007;
    }
}
