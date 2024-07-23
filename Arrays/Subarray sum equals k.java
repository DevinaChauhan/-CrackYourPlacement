import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Initialize a HashMap to store the cumulative sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 having one occurrence

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num; // Calculate the cumulative sum
            // Check if (sum - k) exists in the map
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // Update the frequency of the current cumulative sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
