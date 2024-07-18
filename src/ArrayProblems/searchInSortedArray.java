package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class searchInSortedArray {
    public static int search(List<Integer> nums, int target) {
        int index = nums.indexOf(target);
        return index != -1 ? index : -1;
    }


    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
        int target = 7;

        int result = search(nums, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}
