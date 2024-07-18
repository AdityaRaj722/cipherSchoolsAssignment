package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class power {
    public static List<List<Integer>> powers(List<Integer> nums) {
        List<List<Integer>> totalSubsets = new ArrayList<>();
        int n = nums.size();
        // Iterate over all possible subsets
        for (int num = 0; num < (1 << n); num++) {
            List<Integer> subset = new ArrayList<>();
            // Construct subset based on bitmask
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    subset.add(nums.get(i));
                }
            }

            // Add subset to the list of subsets
            totalSubsets.add(subset);
        }

        return totalSubsets;
    }
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);

        List<List<Integer>> subsets = powers(nums);

        // Print all subsets
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
