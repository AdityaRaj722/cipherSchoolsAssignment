package DP.L37;

public class LongestCommonSubsequence {

    // Utility method to return the maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Method to find the length of the longest common subsequence
    static int lcs(String X, String Y, int m, int n) {
        // Base case: If either string length is 0, the LCS length is 0
        if (m == 0 || n == 0)
            return 0;

        // If the last characters of both strings match
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcs(X, Y, m - 1, n - 1);

            // If the last characters do not match, find the maximum by either
            // removing the last character from the first string or the second string
        else
            return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        System.out.println("Length of LCS is " + lcs(X, Y, m, n));
    }
}
