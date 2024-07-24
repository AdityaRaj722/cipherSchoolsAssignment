package Trees.L30;

import java.util.PriorityQueue;
import java.util.Collections;

public class median {
    private static PriorityQueue<Integer> maxHeap; // max heap for the lower half
    private static PriorityQueue<Integer> minHeap; // min heap for the upper half

    public void MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public static void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 15, 1, 3};
        for (int num : nums) {
            addNum(num);
            System.out.println("Current median: " + findMedian());
        }
    }
}
