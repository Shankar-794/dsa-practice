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

    void dfs(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node+" ");
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour, visited);
            }
        }
    }
    void connectedComponents(){
        boolean[] visited = new boolean[V];
        int components = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                components++;
                System.out.print("Component "+components+": ");
                dfs(i,visited);
                System.out.println("");
            }
        }
    }

    boolean hasCycleDFS(int node, int parent, boolean[] visited){
        visited[node] = true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                if(hasCycleDFS(neighbour,node,visited)){
                    return true;
                }
            }
            else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }
    boolean hasCycle(){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(hasCycleDFS(i, -1, visited))
                    return true;
            }
        }
        return false;
    }
}
public class Main{
    public static void main(String[] args) {
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 2);
        g.connectedComponents();
        if(g.hasCycle()){
            System.out.println("Cycle Exists!!");
        }
        else
            System.out.println("No cycle");
    }
}   