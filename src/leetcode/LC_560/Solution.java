package leetcode.LC_560;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 */
class Solution {
    int subarraySum(int[] nums, int k) {
        int result = 0;

        // Validate input array
        if (nums == null || nums.length == 0)
            return result;
        final int N = nums.length;

        // Memorize the cumulative sums' histogram so far
        Map<Integer, Integer> histogram = new HashMap<>(N);
        histogram.put(0, 1);
        int cumulation = 0;

        for (int i = 0; i < N; i++) {
            final int curSum = cumulation + nums[i];

            // Check if there is a previous cumulative sum,
            // s.t. curSum - sum == k
            Integer prevCount = histogram.get(curSum - k);
            if (prevCount != null)
                result += prevCount;

            // Update histogram
            Integer curCount = histogram.getOrDefault(curSum, 0);
            histogram.put(curSum, curCount + 1);

            cumulation = curSum;
        }
        return result;
    }
}
