package L42;

import java.util.Arrays;

public class UnionFind {
    private int[] parent;
    private int[] rank; // For optimization

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initially, each element is its own parent
        }
        Arrays.fill(rank, 0); // Initialize rank to 0
    }

    public int find(int i) {
        if (parent[i] != i) {
            // Path compression heuristic
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            // Union by rank heuristic
            if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public static void main(String[] args) {
        int n = 10; // Number of elements
        UnionFind uf = new UnionFind(n);

        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);

        System.out.println("1 and 3 are connected: " + uf.connected(1, 3)); // Output: true
        System.out.println("1 and 4 are connected: " + uf.connected(1, 4)); // Output: false
    }
}
