package StackAndQueue.L20;

import java.util.*;

public class NextGreaterElementAndLargestRectangleArea {

    // Question 1: Next Greater Element
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        int[] next = new int[nums2.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    // Helper method to get next smaller element index
    private static void getNextSmallerIdx(int[] res, int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = heights.length - 1; i >= 0; i--) {
            int curr = heights[i];
            while (stack.peek() != -1 && heights[stack.peek()] >= curr) {
                stack.pop();
            }
            res[i] = stack.peek();
            stack.push(i);
        }
    }

    // Helper method to get previous smaller element index
    private static void getPrevSmallerIdx(int[] res, int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            while (stack.peek() != -1 && heights[stack.peek()] >= curr) {
                stack.pop();
            }
            res[i] = stack.peek();
            stack.push(i);
        }
    }

    // Question 2: Largest Rectangle Area
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        Arrays.fill(nextSmaller, n);

        getNextSmallerIdx(nextSmaller, heights);
        getPrevSmallerIdx(prevSmaller, heights);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int currL = heights[i];
            int currB = nextSmaller[i] - prevSmaller[i] - 1;
            int area = currL * currB;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("Good one");
    }
}
