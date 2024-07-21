import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to handle duplicates
        Helper(nums, 0, nums.length - 1, result);
        return result;
    }

    public void Helper(int[] nums, int left, int right, List<List<Integer>> result) {
        if (left == right) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            Set<Integer> swapped = new HashSet<>();  
            for (int i = left; i <= right; i++) {
                if (swapped.add(nums[i])) 
                    swap(nums, left, i);
                    Helper(nums, left + 1, right, result);
                    swap(nums, left, i);  
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
