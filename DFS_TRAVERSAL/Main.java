import java.util.*;
class Graph{
    int V;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    void printGraph(){
        for(int i=0;i<V;i++){
            System.out.print(i+" -> ");
            for(int neighbour:adj.get(i)){
                System.out.print(neighbour+" ");
            }
            System.out.println();
        }
    }

    void bfs(int start){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        System.out.print("BFS TRAVERSAL: ");
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for(int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    void dfs(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node+" ");
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour, visited);
            }
        }
    }
}

public class Main{
    public static void main(String[] a){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.printGraph();
        g.bfs(0);
        g.dfs(0, new boolean[V]);
    }
}