package DP.L38;

public class EditDistance {

    // Utility method to find the minimum of three integers
    static int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    // Method to find the minimum edit distance between two strings
    static int editDistDP(String str1, String str2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using the bottom-up approach
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, insert all characters of second string
                if (i == 0)
                    dp[i][j] = j;

                    // If second string is empty, remove all characters of first string
                else if (j == 0)
                    dp[i][j] = i;

                    // If last characters are the same, ignore the last character and move on
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If last characters are different, consider all possibilities
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1][j - 1]); // Replace
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println("Minimum Edit Distance: " + editDistDP(str1, str2, str1.length(), str2.length()));
    }
}
