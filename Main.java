
import java.util.*;

class Graph {

    int V;
    LinkedList<LinkedList<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new LinkedList<>();
        for(int i=0;i<V; i++){
            adj.add(new LinkedList<>());
        }
    }
    

    void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void printGraph() {

        for(int i=0;i<V;i++){
            System.out.print(i+ " -> ");
            for(int neighbour: adj.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println("");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.printGraph();
    }
}
