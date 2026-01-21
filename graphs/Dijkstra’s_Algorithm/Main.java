import java.util.*;

class Graph {

    int V;
    ArrayList<ArrayList<Pair>> adj;

    // Helper class to store (node, weight)
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Pair(v, weight));
        // If undirected, uncomment next line
        // adj.get(v).add(new Pair(u, weight));
    }

    public int[] dijkstra(int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap based on distance
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int currDist = curr.weight;

            // Skip outdated entries
            if (currDist > dist[node])
                continue;

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.weight;

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }
}

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 4, 1);

        int[] dist = g.dijkstra(0);
        System.out.println(Arrays.toString(dist));
    }
}
