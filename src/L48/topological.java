package L48;

import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor
    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        for (Integer neighbor : adj[v]) {
            if (!visited[neighbor])
                topologicalSortUtil(neighbor, visited, stack);
        }

        // Push current vertex to stack which stores the result
        stack.push(v);
    }

    // The function to do Topological Sort. It uses recursive topologicalSortUtil()
    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Print contents of stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Driver method
    public static void main(String args[]) {
        Graph g = new Graph(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological Sort of the given graph:");
        g.topologicalSort();
    }
}

