package DP.L35;

public class PalindromicSubsequences {
    public static int countPS(String str) {
        int N = str.length();
        int[][] cps = new int[N][N];

        // Single length substrings are palindromic
        for (int i = 0; i < N; i++) {
            cps[i][i] = 1;
        }

        // Build the table
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i <= N - L; i++) {
                int k = L + i - 1;

                if (str.charAt(i) == str.charAt(k)) {
                    cps[i][k] = cps[i][k - 1] + cps[i + 1][k] + 1;
                } else {
                    cps[i][k] = cps[i][k - 1] + cps[i + 1][k] - cps[i + 1][k - 1];
                }
            }
        }

        return cps[0][N - 1];
    }

    public static void main(String[] args) {
        String str = "abcb";
        System.out.println("Count of Palindromic Subsequences: " + countPS(str));
    }
}

