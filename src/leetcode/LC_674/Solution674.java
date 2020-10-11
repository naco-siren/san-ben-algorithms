package leetcode.LC_674;

/**
 * 674. Longest Continuous Increasing Subsequence
 */
public class Solution674 {
    /*
     * Leetcode approach
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i])
                anchor = i;

            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    /*
     * My approach
     */
    public int findLengthOfLCIS2(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int result = 1;
        int start = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            final int num = nums[i];
            if (num > prev) {
                result = Math.max(result, i - start + 1);
            } else {
                start = i;
            }
            prev = num;
        }
        return result;
    }
}
