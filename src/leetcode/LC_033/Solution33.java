package leetcode.LC_033;

/**
 * 33. Search in Rotated Sorted Array
 */
class Solution33 {
    public int search(int[] nums, int target) {
        // Corner case
        if (nums == null || nums.length == 0)
            return -1;

        // Perform binary search
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // Check current mid
            int mid = (left + right) / 2;   // Might overflow in extreme cases
            if (nums[mid] == target)
                return mid;

            // First check if target falls onto left half
            if (inRange(nums[left],         nums[mid],      target)) {   // NOTE `nums[mid]` here! We are ONLY focusing on the LEFT half.
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private boolean inRange(final int left, final int right, final int target) {    // NOTE we DON'T pass array & index here
        // 1. If this is a normal ascending array
        if (left <= target && target <= right)
            return true;

        // 2. If this is a reverted array
        //
        // e.g. [6, 7, 8, 9, 1, 2, 3]
        if (left > right &&
                (target >= left || target <= right))    // NOTE the "OR" here.
            return true;

        return false;
    }
}
