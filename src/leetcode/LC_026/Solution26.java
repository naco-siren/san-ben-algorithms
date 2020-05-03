package leetcode.LC_026;

/**
 * 26. Remove Duplicates from Sorted Array
 */
class Solution26 {
    int removeDuplicates(int[] nums) {
        // Handle corner cases
        if (nums == null)
            return -1;
        final int N = nums.length;
        if (N <= 1)
            return N;

        // Use a Read pointer and Writer pointer to perform removal
        int r = 1, w = 1;
        while (r < nums.length) {
            while (r < nums.length && nums[r] == nums[w - 1])
                r++;

            if (r < nums.length)
                nums[w++] = nums[r++];
        }
        return w;
    }
}
