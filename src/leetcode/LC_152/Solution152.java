package leetcode.LC_152;

/**
 * 152. Maximum Product Subarray
 */
class Solution152 {
    int maxProduct(int[] nums) {
        // Guard against corner cases
        if (nums == null || nums.length == 0)
            return 0;

        // Whilst iteration, memorize the max abs of consecutive product till `i` so far
        int maxProduct = nums[0];
        int maxPos = Math.max(nums[0], 0), minNeg = Math.min(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            final int maxPosCpy = maxPos;
            // THE KEY IS TO NOT ATTEMPT MANUALLY SORTING OUT THE CASES!
            maxPos = Math.max(nums[i] * maxPosCpy, Math.max(minNeg * nums[i], nums[i]));
            minNeg = Math.min(nums[i] * maxPosCpy, Math.min(minNeg * nums[i], nums[i]));
            maxProduct = Math.max(maxProduct, maxPos);
        }
        return maxProduct;
    }
}
