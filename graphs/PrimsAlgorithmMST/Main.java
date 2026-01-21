import java.util.*;
class Graph{
    int V;
    ArrayList<ArrayList<Pair>> adj;
    static class Pair{
        int node;
        int weight;

        Pair(int node,int weight){
            this.node = node;
        this.weight = weight;
        }
    }

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u, int v, int w){
        adj.get(u).add(new Pair(v,w));
        adj.get(v).add(new Pair(u,w));
    }
    public int primMST(){
        boolean[] inMST = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(0,0));
        int totalWeight = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;
            if(inMST[node])
                continue;
            inMST[node] = true;
            totalWeight += weight;
            for(Pair neighbour: adj.get(node)){
                if(!inMST[neighbour.node]){
                    pq.add(new Pair(neighbour.node,neighbour.weight));  
                }
            }
        }
        return totalWeight;
    }
}
public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);

        System.out.println("MST total weight: " + g.primMST());
    }
}
