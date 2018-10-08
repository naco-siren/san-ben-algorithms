package companies.uber.move_zero;

public class Solution {
    public static void main(String[] args) {
        int[] i1 = new int[]{0, 1, 4, 0, 2, 0, 8, 0, 0, 5, 0, 7};
        moveZeroToFront(i1);    // {0, 0, 0, 0, 0, 0, 1, 4, 2, 8, 5, 7}
    }

    public static void moveZeroToFront(final int[] nums) {
        int len = nums.length;

        int r = len - 1, w = len - 1;
        while (r >= 0) {
            // Read pointer: Find the first non-zero value
            while (r >= 0 && nums[r] == 0)
                r--;

            if (r >= 0)
                nums[w--] = nums[r--];
        }
        while (w >= 0)
            nums[w--] = 0;
    }
}
