package leetcode.LC_015;

import java.util.*;

/**
 * 15. 3Sum
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        // Early return on invalid input
        if (nums == null || nums.length < 3)
            return result;

        // Sort array to reduce entropy
        Arrays.sort(nums);

        // Lock down the first number and then do 2sum
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip identical numbers for `i`
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            final int a = nums[i], target = -a;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip identical numbers for `j` and `k`
                    while (j < k && nums[j] == nums[j+1])
                        j++;
                    while (j < k && nums[k] == nums[k-1])
                        k--;

                    j++;
                    k--;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
