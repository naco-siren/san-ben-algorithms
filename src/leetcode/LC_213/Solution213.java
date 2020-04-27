package leetcode.LC_213;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
class Solution213 {
    int[] searchRange(int[] nums, int target) {
        // Guard corner cases
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        if (nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1, -1};

        final int first = findFirst(nums, target);
        final int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {  // Allow `lo` == `hi` to perform edge case checks!
            int mid = lo + ((hi - lo) / 2);

            // Early return `mid` on capture
            if (arr[mid] == x && (mid == 0 || arr[mid] > arr[mid - 1]))
                return mid;

            // Notice the `>`=
            if (arr[mid] >= x) {    // Allow `arr[mid]` == `x` here because it has been verified above to be NOT the first
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private static int findLast(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {  // Allow `lo` == `hi` to perform edge case checks!
            int mid = lo + ((hi - lo) / 2);

            // Early return `mid` on capture
            if (arr[mid] == x && (mid == arr.length - 1 || arr[mid] < arr[mid + 1]))
                return mid;

            // Notice the `<`=
            if (arr[mid] <= x) { // Allow `arr[mid]` == `x` here because it has been verified above to be NOT the last
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    @Deprecated
    private int findFirstBad(int[] nums, int target) {
        int first = -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            final int mid = (l + r) / 2;
            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return nums[l] == target ? l : (l < nums.length - 1 && nums[l+1] == target ? l + 1 : -1);
    }

    @Deprecated
    private int findLastBad(int[] nums, int target) {
        int last = -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            final int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
                // } else if (nums[mid] < target) {
                //     l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return nums[l] == target ? l : (l > 0 && nums[l-1] == target ? l - 1 : -1);
    }
}
