package leetcode.LC_523;

import java.util.HashMap;

/**
 * 523. Continuous Subarray Sum
 */
class Solution523 {
    boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> sumModKIdx = new HashMap<>();
        sumModKIdx.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // We only care about the remainder of `sum` divided by `k`, i.e. mod,
            // because if a previous `oldSum` with the same mod exist, then `sum - oldSum` must be a multiple of `k`.
            if (k != 0)
                sum = sum % k;

            Integer prevSumIdx = sumModKIdx.get(sum);
            if (prevSumIdx == null) {
                sumModKIdx.put(sum, i);

            } else {
                if (i - prevSumIdx > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
