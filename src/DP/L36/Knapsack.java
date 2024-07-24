package DP.L36;

public class Knapsack {
    // Utility method to return the maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Method to solve the knapsack problem
    static int knapSack(int W, int[] wt, int[] val, int n) {
        // Base case: If no items or capacity is 0, return 0
        if (n == 0 || W == 0)
            return 0;

        // If the weight of the nth item is more than the knapsack capacity W, skip this item
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        else
            // Return the maximum of two cases:
            // 1. nth item included
            // 2. nth item not included
            return max(
                    val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1)
            );
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println("Maximum value in knapsack = " + knapSack(W, wt, val, n));
    }
}
