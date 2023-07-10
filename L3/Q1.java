import java.util.*;

public class Q1 {
    static int n;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();

        // Create the graph
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
        }

        // Initialize visited array and dp array
        visited = new boolean[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int result = dfs(1);

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    static int dfs(int node) {
        if (node == n) {
            return 1;
        }

        if (visited[node]) {
            return -1; // Cycle detected
        }

        if (dp[node] != -1) {
            return dp[node]; // Return already calculated result
        }

        visited[node] = true;
        int maxLocations = -1;

        for (int nextNode : graph.get(node)) {
            int result = dfs(nextNode);
            if (result != -1) {
                maxLocations = Math.max(maxLocations, result + 1);
            }
        }

        visited[node] = false;
        dp[node] = maxLocations;

        return maxLocations;
    }
}