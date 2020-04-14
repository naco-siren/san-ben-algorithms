package leetcode.LC_031;

import java.util.Arrays;

/**
 * 31. Next Permutation
 */
public class Solution {

    public static void nextPermutation(int[] nums) {
        // Find the longest descending subarray starting from the right end.
        int s = nums.length - 1;
        while (s > 0 && nums[s-1] >= nums[s])
            s--;

        // Early return if the whole array is descending
        if (s == 0 || nums.length < 2) {
            reverse(nums, 0);
            return;
        }

        // Find the smallest number in this subarray yet larger than the one right before the subarray.
        final int target = nums[s-1];
        int src = Integer.MAX_VALUE, srcIdx = -1;
        for (int i = s; i < nums.length; i++) {
            if (nums[i] <= target)
                continue;
            if (nums[i] <= src) {
                src = nums[i];
                srcIdx = i;
            }
        }

        // Swap these two numbers and reverse the subarray.
        nums[s-1] = src;
        nums[srcIdx] = target;

        reverse(nums, s);
    }

    private static void reverse(final int[] nums, final int start) {
        for (int l = start, r = nums.length - 1; l < r; l++, r--) {
            final int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
