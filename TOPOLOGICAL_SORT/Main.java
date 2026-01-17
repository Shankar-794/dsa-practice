
import java.util.*;

class Graph {

    int V;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private void dfs(int node,
            boolean[] visited,
            Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }

        // post-order insertion
        stack.push(node);
    }

    public int[] topoSort() {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        int[] topo = new int[V];
        int index = 0;

        while (!stack.isEmpty()) {
            topo[index++] = stack.pop();
        }

        return topo;
    }
}

public class Main{
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.print("Topological Sort: ");
        System.out.println(Arrays.toString(g.topoSort()));
    }
}
