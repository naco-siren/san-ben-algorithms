package leetcode.LC_283;

/**
 * 283. Move Zeroes
 */
public class Solution283 {
    void moveZero(final int[] nums) {
        int len = nums.length;

        int r = 0, w = 0;
        while (r < len) {
            // Read pointer: Find the first non-zero value
            while (r < len - 1 && nums[r] == 0)
                r++;

            if (r < len)
                nums[w++] = nums[r++];
        }
        while (w < len)
            nums[w++] = 0;
    }
}
