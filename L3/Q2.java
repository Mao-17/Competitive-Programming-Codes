import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println("YES");
            return;
        }

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int center = findCenter(graph);
        if (center != -1 && isStarTree(graph, center)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int findCenter(List<List<Integer>> graph) {
        int n = graph.size() - 1;
        int[] degree = new int[n + 1];
        int center = -1;

        for (int i = 1; i <= n; i++) {
            int size = graph.get(i).size();
            degree[i] = size;

            if (size > 1) {
                if (center != -1) {
                    return -1; // More than one node with degree > 1, not a star
                }
                center = i;
            }
        }

        if (center == -1) {
            return 1; // Tree has only one node, which is a star
        }

        for (int v : graph.get(center)) {
            if (degree[v] > 1) {
                return -1; // One of the connected nodes has degree > 1, not a star
            }
        }

        return center;
    }

    private static boolean isStarTree(List<List<Integer>> graph, int center) {
        int n = graph.size() - 1;
        boolean[] visited = new boolean[n + 1];

        visited[center] = true;
        int visitedCount = 1;

        for (int v : graph.get(center)) {
            visited[v] = true;
            visitedCount++;
        }

        if (visitedCount != n) {
            return false; // Not all nodes are visited, not a star
        }

        return true;
    }
}
