package leetcode.LC_042;

/**
 * 42. Trapping Rain Water
 */
class Solution42 {
    /**
     * For each column (index `i`), the water it holds is `min(leftMax, rightMax) - height[i]`.
     */
    int trap(int[] height) {
        int water = 0;

        // Handle corner case
        final int N = height.length;
        if (N < 2)
            return water;

        // Construct an array of max height on the left
        int[] leftMax = new int[N];
        leftMax[0] = height[0];
        for (int i = 1; i < N; i++)
            leftMax[i] = Math.max(leftMax[i-1], height[i]);

        // Reverse traversal for max right on the right, no need an array now since water is calculated ad-hoc
        int rightMax = 0;
        for (int i = N - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            water += Math.min(leftMax[i], rightMax) - height[i];
        }
        return water;
    }
}
