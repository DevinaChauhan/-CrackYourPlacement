import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a PriorityQueue to store the elements based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        // Add all entries to the PriorityQueue
        pq.addAll(frequencyMap.entrySet());

        // Step 3: Extract the top k elements
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = pq.poll().getKey();
        }

        return topK;
    }
}
