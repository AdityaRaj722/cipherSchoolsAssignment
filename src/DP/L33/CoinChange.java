package DP.L33;

public class CoinChange {

    // Recursive function to count the number of ways to make a given sum
    public static int countWays(int[] coins, int n, int sum) {
        // Base case: if sum is 0, there's one way to make the sum (by not using any coins)
        if (sum == 0) {
            return 1;
        }

        // If sum is less than 0, no way to make the sum
        if (sum < 0) {
            return 0;
        }

        // If there are no coins left and sum is greater than 0, no way to make the sum
        if (n <= 0) {
            return 0;
        }

        // Count the number of ways by:
        // 1. Excluding the last coin (coins[n-1])
        // 2. Including the last coin (coins[n-1]) and reducing the sum by the coin's value
        return countWays(coins, n - 1, sum) + countWays(coins, n, sum - coins[n - 1]);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        int n = coins.length;

        System.out.println("Number of ways to make the sum: " + countWays(coins, n, sum));
    }
}
