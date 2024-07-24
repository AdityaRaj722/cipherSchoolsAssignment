package DP.L40;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static final int V = 4;

    public static boolean isBipartiteUtil(int[][] G, int src, int[] colorArr) {
        colorArr[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (G[u][u] == 1)
                return false;

            for (int v = 0; v < V; ++v) {
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.add(v);
                } else if (G[u][v] == 1 && colorArr[v] == colorArr[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] G) {
        int[] colorArr = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        for (int i = 0; i < V; ++i) {
            if (colorArr[i] == -1) {
                if (!isBipartiteUtil(G, i, colorArr))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] G = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        if (isBipartite(G)) {
            System.out.println("Yes, the graph is bipartite.");
        } else {
            System.out.println("No, the graph is not bipartite.");
        }
    }
}
