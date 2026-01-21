
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

    public int[] topoSortBFS(){
        int[] indegree = new int[V];
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[index++] = node;
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
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
        System.out.print("Topological Sort using \"Kahn's Algorithm\" : ");
        System.out.print(Arrays.toString(g.topoSortBFS()));
    }
}