package RecursionAndBacktracking.L12;

import java.util.ArrayList;
import java.util.List;

public class powerSet {

    public static List<List<Integer>> power(List<Integer> nums) {
        List<List<Integer>> totalSubsets = new ArrayList<>();
        int n = nums.size();
        int totalSubsetsCount = 1 << n; // 2^n

        for (int num = 0; num < totalSubsetsCount; num++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    subset.add(nums.get(i));
                }
            }
            totalSubsets.add(subset);
        }
        return totalSubsets;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);
        List<List<Integer>> subsets =power(nums);
        System.out.println("Subsets: " + subsets);
    }
}

