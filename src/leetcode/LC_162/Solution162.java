package leetcode.LC_162;

/**
 * 162. Find Peak Element
 */
class Solution162 {
    int findPeakElement(int[] nums) {
        // Handle corner cases
        if (nums == null || nums.length == 0)
            return -1;

        int candidate = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                candidate = i;
            } else {
                return i - 1;
            }
        }
        return candidate;
    }
}
