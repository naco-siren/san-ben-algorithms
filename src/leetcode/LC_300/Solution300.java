package leetcode.LC_300;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 */
public class Solution300 {

    /**
     *
     * Approach #3: Dynamic Programming (with Binary Search)
     *
     */
    public int lengthOfLIS(int[] nums) {
        // Handle corner cases
        if (nums == null || nums.length == 0)
            return 0;
        final int N = nums.length;

        // Perform dynamic programming
        int maxIdx = 0;
        int[] dp = new int[N];
        dp[0] = nums[0];    // So that we can start from index `1`.
        for (int i = 1; i < N; i++) {
            if (nums[i] > dp[maxIdx]) {
                dp[++maxIdx] = nums[i];     // NOTE that `maxIdx` is updated ONLY HERE! See test case `lengthOfLIS_3`.
            } else {
                final int targetIdx = binarySearch(dp, maxIdx, nums[i]);
                dp[targetIdx] = nums[i];
            }
        }
        return maxIdx + 1;  // index of `i` correspond to length [o:i], i.e. `i + 1`
    }

    private int binarySearch(final int[] arr, int r, int target) {
        int l = 0;
        while (l <= r) {    // NOTE `<=` here!! See test case `lengthOfLIS_4`.
                            // TL,DR: `l < r` find out the one smaller than target,
                            // meanwhile, `l <= r` will force another loop when `r == l+1`, s.t. `l` becomes `l+1`.
            final int m = (l + r) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * Approach #1: recursively pick (if possible) and not pick each element.
     *
     * Time complexity: O(2^n), size of recursion tree
     * Space complexity: O(n^2), memo array of size `n * n` is used
     */
    public int lengthOfLISRecur1(int[] nums) {
        return helper(nums, Integer.MIN_VALUE, 0);
    }

    public int helper(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + helper(nums, nums[curpos], curpos + 1);
        }
        int nottaken = helper(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }
    /**
     * Approach #2: Recursion with Memoization
     *
     * Time complexity: O(n^2), size of recursion tree
     * Space complexity: O(n^2), memo array of size `n * n` is used
     */
    public int lengthOfLISRecur2(int[] nums) {
        int memo[][] = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lengthofLIS(nums, -1, 0, memo);
    }

    public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
        if (curpos == nums.length) {
            return 0;
        }
        if (memo[previndex + 1][curpos] >= 0) {
            return memo[previndex + 1][curpos];
        }
        int taken = 0;
        if (previndex < 0 || nums[curpos] > nums[previndex]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
        }

        int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
        return memo[previndex + 1][curpos];
    }
}
