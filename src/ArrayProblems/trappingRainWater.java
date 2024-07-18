package ArrayProblems;

public class trappingRainWater {
    public static int helper(int[] height){
        int totWater = 0;
        int n = height.length;

        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        // Fill the left array
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // Fill the right array
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // Calculate the trapped water
        for (int i = 0; i < n; i++) {
            int currWater = Math.min(left[i], right[i]) - height[i];
            totWater += currWater;
        }

        return totWater;
    }
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans=helper(heights);
        System.out.println(ans);
    }
}
