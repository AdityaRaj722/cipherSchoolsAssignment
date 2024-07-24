package DP.L34;

public class SubsetSum {
    static int[][] tab;

    public static int subsetSum(int[] a, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        if (tab[n - 1][sum] != -1) {
            return tab[n - 1][sum];
        }
        if (a[n - 1] > sum) {
            return tab[n - 1][sum] = subsetSum(a, n - 1, sum);
        } else {
            return tab[n - 1][sum] = subsetSum(a, n - 1, sum) == 1 ||
                    subsetSum(a, n - 1, sum - a[n - 1]) == 1 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = a.length;

        // Initialize memoization table with -1
        tab = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                tab[i][j] = -1;
            }
        }

        if (subsetSum(a, n, sum) == 1) {
            System.out.println("Found a subset with the given sum.");
        } else {
            System.out.println("No subset with the given sum.");
        }
    }
}
