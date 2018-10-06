package leetcode.LC_189;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (k == 0) return;

        reverse(nums, 0, len);
        reverse(nums, 0, k);
        reverse(nums, k, len);
    }

    private void reverse(int[] nums, int l, int r) {
        for (int i = l; i < (l + r) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[l + r - 1 - i];
            nums[l + r - 1 - i] = temp;
        }
    }
}
