package leetcode.LC_011;

/**
 * 11. Container With Most Water
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int l = 0, r = height.length - 1; l < r; ) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, cur);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
