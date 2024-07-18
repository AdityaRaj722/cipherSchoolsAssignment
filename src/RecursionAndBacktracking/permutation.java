package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class permutation {

    private static void solve(List<Integer> nums, List<List<Integer>> ans, int index) {
        if (index >= nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            // Swap elements at index and i
            swap(nums, index, i);
            // Recurse to generate permutations from index + 1
            solve(nums, ans, index + 1);
            // Backtrack by swapping back
            swap(nums, index, i);
        }
    }

    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, 0);
        return ans;
    }
    }
