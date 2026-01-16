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

    private boolean dfs(int node, boolean[] visited, boolean[] dfsStack) {

        visited[node] = true;
        dfsStack[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, dfsStack))
                    return true;
            }
            else if (dfsStack[neighbor]) {
                return true;
            }
        }

        // backtrack
        dfsStack[node] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] dfsStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, dfsStack))
                    return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        if (g.isCyclic()) {
            System.out.println("Given Directed Graph has a Cycle");
        } else {
            System.out.println("Given Directed Graph has no Cycle");
        }
    }
}
