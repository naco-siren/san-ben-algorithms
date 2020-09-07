package leetcode.LC_034;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
class Solution34 {
    /**
     * Approach 1: My solution
     */
    public int[] searchRange(int[] nums, int target) {
        // Guard corner cases
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        if (nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1, -1};

        // Find first position of target element
        int first = -1;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            final int mid = (lo + hi) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {  // Remember to always check for target and break/return
                first = mid;
                break;
            }

            if (nums[mid] < target) {   // If `nums[mid] == target`, then you wanna decrement `hi` by one, which is the same as `nums[mid] > target`
                lo = mid + 1;           // Therefore, `<` is on one side, while `>=` is on another side.
            } else {
                hi = mid - 1;
                // hi = mid             // also works, but let's keep `hi = mid - 1` to be symmetrical with the second half
            }
        }
        if (first == -1)
            first = nums[lo] == target ? lo : -1;

        // Early return if first not found
        if (first == -1)
            return new int[]{-1, -1};



        // Find last position of target element
        int last = -1;
        lo = first; hi = nums.length - 1;
        while (lo < hi) {
            final int mid = (lo + hi) / 2;

            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {    // Ditto
                last = mid;
                break;
            }

            if (nums[mid] > target) {   // If `nums[mid] == target`, then you wanna increment `lo` by one, which is the same as `nums[mid] < target`
                hi = mid - 1;           // Therefore, `>` is on one side, while `<=` is on another side.
            } else {
                lo = mid + 1;
            }
        }
        if (last == -1)
            last = nums[hi] == target ? hi : -1;
//          last = nums[lo] == target ? hi : -1;    // WILL ALSO WORK! `lo` and `hi` are equal on exiting this loop.

        return new int[]{first, last};
    }

//
//    /**
//     * Approach 2: Official solution
//     */
//    public int[] searchRange2(int[] nums, int target) {
//        int[] targetRange = {-1, -1};
//
//        int leftIdx = extremeInsertionIndex(nums, target, true);
//
//        // assert that `leftIdx` is within the array bounds and that `target`
//        // is actually in `nums`.
//        if (leftIdx == nums.length || nums[leftIdx] != target) {
//            return targetRange;
//        }
//
//        targetRange[0] = leftIdx;
//        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
//
//        return targetRange;
//    }
//
//    // returns leftmost (or rightmost) index at which `target` should be
//    // inserted in sorted array `nums` via binary search.
//    private int extremeInsertionIndex(int[] nums, int target, boolean leftMost) {
//        int lo = 0;
//        int hi = nums.length;   // ?
//
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if (nums[mid] > target || (leftMost && target == nums[mid])) {
//                hi = mid;
//            } else {
//                lo = mid + 1;
//            }
//        }
//
//        return lo;
//    }
}