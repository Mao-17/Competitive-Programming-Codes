import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        Graph g = new Graph(n + 1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(a, b, w);
        }
        g.precomputeShortestPaths();
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            System.out.println(g.getShortestPath(s, t));
        }
    }

    private static class Graph {
        private int n;
        private ArrayList<ArrayList<Pair>> adjList;
        private int[][] shortestPaths;

        public Graph(int n) {
            this.n = n;
            adjList = new ArrayList<>(n);
            shortestPaths = new int[n][n];
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
                Arrays.fill(shortestPaths[i], Integer.MAX_VALUE);
                shortestPaths[i][i] = 0;
            }
        }

        public void addEdge(int a, int b, int w) {
            adjList.get(a).add(new Pair(b, w));
            adjList.get(b).add(new Pair(a, w));
        }

        public void precomputeShortestPaths() {
            for (int i = 1; i < n; i++) {
                shortestPath(i);
            }
        }

        private void shortestPath(int source) {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n];
            int[] dist = shortestPaths[source];
            Arrays.fill(visited, false);
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;
            pq.add(new Pair(source, 0));
            while (!pq.isEmpty()) {
                Pair curr = pq.poll();
                if (visited[curr.node])
                    continue;
                visited[curr.node] = true;
                for (Pair neighbor : adjList.get(curr.node)) {
                    if (!visited[neighbor.node]) {
                        int newDist = dist[curr.node] + neighbor.weight;
                        if (newDist < dist[neighbor.node]) {
                            dist[neighbor.node] = newDist;
                            pq.add(new Pair(neighbor.node, newDist));
                        }
                    }
                }
            }
        }

        public int getShortestPath(int source, int destination) {
            return shortestPaths[source][destination] == Integer.MAX_VALUE ? -1 : shortestPaths[source][destination];
        }

        private class Pair implements Comparable<Pair> {
            int node;
            int weight;

            public Pair(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }

            @Override
            public int compareTo(Pair other) {
                return Integer.compare(this.weight, other.weight);
            }
        }
    }
}
