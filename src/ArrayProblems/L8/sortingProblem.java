package ArrayProblems.L8;

import java.util.Arrays;

public class sortingProblem {
    public static void sort012(int[] nums) {
        int p0 = 0, p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            switch (nums[p1]) {
                case 0:
                    swap(nums, p0, p1);
                    p0++;
                    p1++;
                    break;
                case 1:
                    p1++;
                    break;
                case 2:
                    swap(nums, p1, p2);
                    p2--;
                    break;
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sort012(nums);
        System.out.println(Arrays.toString(nums));
    }
}
