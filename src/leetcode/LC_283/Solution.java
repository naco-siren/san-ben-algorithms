package leetcode.LC_283;

public class Solution {
    public static void main(String[] args) {
        int[] i1 = new int[]{0, 1, 4, 0, 2, 0, 8, 0, 0, 5, 0, 7};
        moveZero(i1);
    }

    public static void moveZero(final int[] nums) {
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
