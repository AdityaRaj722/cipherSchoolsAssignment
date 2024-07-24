package RecursionAndBacktracking.L11;

public class uniquePath {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the last row and last column
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[j][n - 1] = 1;
        }

        // Fill the dp table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int m = 3; // Example number of rows
        int n = 3; // Example number of columns
        int result = uniquePaths(m, n);
        System.out.println("Number of unique paths: " + result);
    }
}

