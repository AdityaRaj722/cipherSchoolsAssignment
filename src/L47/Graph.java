package L47;

import java.util.*;

class Graph {
    private int V; // Number of vertices
    private List<Integer>[] adj; // Adjacency list

    // Constructor
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Utility function to check if there's a cycle
    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, v)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Check if the graph contains a cycle
    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0); // Adding a cycle

        if (g.isCyclic()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
