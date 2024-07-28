import java.util.*;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        
       
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxVal = 0;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxVal = Math.max(maxVal, num);
        }
        

        int[] points = new int[maxVal + 1];
        for (int num : countMap.keySet()) {
            points[num] = num * countMap.get(num);
        }
        
        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = points[1];
        
        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }
        
        return dp[maxVal];
    }
}
