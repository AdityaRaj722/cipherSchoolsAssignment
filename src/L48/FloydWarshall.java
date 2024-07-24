package L48;

public class FloydWarshall {
    final static int INF = 99999;
    final static int V = 4;

    void floydWarshall(int[][] dist) {
        int i, j, k;
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]
                            && dist[k][j] != INF
                            && dist[i][k] != INF) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int[][] dist) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall a = new FloydWarshall();

        int graph[][] = {
                { 0,   5,  INF, 10 },
                { INF, 0,   3, INF },
                { INF, INF, 0,   1 },
                { INF, INF, INF, 0 }
        };

        a.floydWarshall(graph);
    }
}

