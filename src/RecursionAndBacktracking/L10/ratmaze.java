package RecursionAndBacktracking.L10;

import java.util.ArrayList;
import java.util.List;

public class ratmaze{

    private static void findPathHelper(int i, int j, int[][] a, int n, List<String> ans, String move, int[][] vis) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
            vis[i][j] = 1;
            findPathHelper(i + 1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            vis[i][j] = 1;
            findPathHelper(i, j - 1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }

        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
            vis[i][j] = 1;
            findPathHelper(i, j + 1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            vis[i][j] = 1;
            findPathHelper(i - 1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }

    public static List<String> findPath(int[][] m, int n) {
        List<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];

        if (m[0][0] == 1) findPathHelper(0, 0, m, n, ans, "", vis);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] m = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        List<String> result = findPath(m, n);
        if (result.size() == 0)
            System.out.println(-1);
        else
            for (String path : result) System.out.print(path + " ");
        System.out.println();
    }
}
