package leetcode.LC_525;

import java.util.Arrays;

/**
 * 525. Contiguous Array
 */
public class Solution {
    public static int findMaxLength(int[] nums) {
        // Initialize a diffs array to memorize the first index of any given diff
        int[] diffs = new int[nums.length * 2 + 1];
        Arrays.fill(diffs, -2);     // We use `-2` to indicate empty (i.e. ordinary -1 or null), because...
        diffs[nums.length] = -1;        // ...we need `-1` as a real index to indicate the position before index `0`.

        // Traverse the array and fill the diffs
        int max = 0;
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff += (nums[i] == 1 ? 1 : -1);

            final int key = diff + nums.length;
            if (diffs[key] == -2) {
                diffs[key] = i;
            } else {
                max = Math.max(max, i - diffs[key]);
            }
        }
        return max;
    }
}