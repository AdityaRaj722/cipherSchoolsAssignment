package DP.L37;

import java.util.Arrays;

public class LIP {
    static final int MAX = 1000;

    public static int LIP(int[][] dp, int[][] mat, int n, int m, int x, int y) {
        if (dp[x][y] < 0) {
            int result = 0;
            if (x == n - 1 && y == m - 1)
                return dp[x][y] = 1;
            if (x == n - 1 || y == m - 1)
                result = 1;
            if (x != n - 1 && mat[x][y] < mat[x + 1][y])
                result = 1 + LIP(dp, mat, n, m, x + 1, y);
            if (y != m - 1 && mat[x][y] < mat[x][y + 1])
                result = Math.max(result, 1 + LIP(dp, mat, n, m, x, y + 1));

            dp[x][y] = result;
        }

        return dp[x][y];
    }

    public static int wrapper(int[][] mat, int n, int m) {
        int[][] dp = new int[MAX][MAX];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return LIP(dp, mat, n, m, 0, 0);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int n = 3;
        int m = 3;
        System.out.println(wrapper(mat, n, m));
    }
}
