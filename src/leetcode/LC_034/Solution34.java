package leetcode.LC_034;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        // Guard corner cases
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        if (nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1, -1};

        // Find first position of target element
        int first = -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            final int mid = (l + r) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {  // Remember to always check for target and break/return
                first = mid;
                break;
            }

            if (nums[mid] < target) {   // Focus on the condition that ALIGNS with your search direction (to the LEFT)
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (first == -1)
            first = nums[l] == target ? l : -1;

        // Early return if first not found
        if (first == -1)
            return new int[]{-1, -1};

        // Find last position of target element
        int last = -1;
        l = first; r = nums.length - 1;
        while (l < r) {
            final int mid = (l + r) / 2;

            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {    // Ditto
                last = mid;
                break;
            }

            if (nums[mid] > target) {   // Focus on the condition that ALIGNS with your search direction (to the RIGHT)
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (last == -1)
            last = nums[r] == target ? r : -1;

        return new int[]{first, last};
    }
}