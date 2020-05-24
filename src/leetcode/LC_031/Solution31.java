package leetcode.LC_031;


/**
 * 31. Next Permutation
 */
public class Solution31 {

    void nextPermutation(int[] nums) {
        // Find the longest descending subarray starting from the right end.
        // e.g. [1,2,5,4,3]  ->  s = 2
        //
        int s = nums.length - 1;
        while (s > 0 && nums[s-1] >= nums[s])
            s--;

        // Early return if the whole array is descending
        if (s == 0 || nums.length < 2) {
            reverse(nums, 0);
            return;
        }

        // Find the smallest number in this subarray yet larger than the one right before the subarray, i.e. `ceiling`,
        // as we DO NOT want to modify the digits before `s`, that would change the value in a much larger scale.
        //
        // And apparently it must exist, because `nums[s] < nums[s+1]` is the condition for breaking the loop!
        final int source = nums[s-1];
        int ceiling = Integer.MAX_VALUE, ceilingIdx = -1;
        for (int i = s; i < nums.length; i++) {
            if (nums[i] <= source)
                continue;

            if (nums[i] <= ceiling) {
                ceiling = nums[i];
                ceilingIdx = i;
            }
        }

        // Swap these two numbers and reverse the subarray.
        nums[s-1] = ceiling;
        nums[ceilingIdx] = source;

        reverse(nums, s);
    }

    void reverse(final int[] nums, final int start) {
        for (int l = start, r = nums.length - 1; l < r; l++, r--) {
            final int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
