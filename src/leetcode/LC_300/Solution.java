package leetcode.LC_300;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int r1 = solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});   // 4
        int r2 = solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4});   // 3
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0]; int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[maxIdx]) {
                dp[++maxIdx] = nums[i];
            } else {
                binarySearch(dp, maxIdx, nums[i]);
            }
        }
        return maxIdx + 1;
    }

    private void binarySearch(final int[] arr, int r, int target) {
        int l = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) {
                return;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        arr[l] = target;
    }
}
