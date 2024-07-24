package DP.L34;

public class MaxSumIS {
    public static int maxSumIS(int[] arr, int n) {
        int maxSum = 0;
        int[] msis = new int[n];

        // Initialize msis values with the array values
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
        }

        // Compute maximum sum values in bottom-up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }

        // Pick the maximum value from msis
        for (int i = 0; i < n; i++) {
            if (maxSum < msis[i]) {
                maxSum = msis[i];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Maximum Sum Increasing Subsequence is " + maxSumIS(arr, n));
    }
}
