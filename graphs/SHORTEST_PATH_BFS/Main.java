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
        adj.get(v).add(u);
    }

    public int[] shortestPath(int src){
        int[] dist = new int[V];
        Arrays.fill(dist,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour : adj.get(node)){
                if(dist[neighbour]== -1){
                    dist[neighbour] = dist[node]+1;
                    q.add(neighbour);
                }
            }
        }
        
        return dist;
    }
}

public class Main{
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        System.out.print("Shortest Path : ");
        System.out.println(Arrays.toString(g.shortestPath(0)));
    }
}