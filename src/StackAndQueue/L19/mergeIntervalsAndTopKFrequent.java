package StackAndQueue.L19;

import java.util.*;

public class mergeIntervalsAndTopKFrequent {

    // Method to merge overlapping intervals
    public static List<List<Integer>> merge(List<List<Integer>> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        List<List<Integer>> overlapList = new ArrayList<>();

        for (int i = 0; i < intervals.size() - 1; i++) {
            List<Integer> current = intervals.get(i);
            List<Integer> next = intervals.get(i + 1);

            if (next.get(0) <= current.get(1)) {
                // Merge intervals
                next.set(0, Math.min(current.get(0), next.get(0)));
                next.set(1, Math.max(current.get(1), next.get(1)));
            } else {
                overlapList.add(current);
            }
        }
        overlapList.add(intervals.get(intervals.size() - 1)); // Add the last interval

        return overlapList;
    }

    // Method to find the top K frequent elements
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getValue().equals(b.getValue())) {
                        return Integer.compare(b.getKey(), a.getKey()); // Sort by key if frequencies are the same
                    }
                    return Integer.compare(b.getValue(), a.getValue()); // Sort by value (frequency)
                }
        );

        pq.addAll(freqMap.entrySet());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Excellent");
    }
}

