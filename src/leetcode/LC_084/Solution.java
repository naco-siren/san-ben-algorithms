package leetcode.LC_084;

/**
 * Created by naco_siren on 7/17/17.
 */
public class Solution {
    public static void main(String[] args) {
        int r1 = largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3});

        return;
    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;

        /* idx of the first bar on the left that is lower than current */
        int[] lessFromLeft = new int[len];
        lessFromLeft[0] = -1;

        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i])
                p = lessFromLeft[p];
            lessFromLeft[i] = p;
        }

        /* idx of the first bar on the right that is lower than current */
        int[] lessFromRight = new int[len];
        lessFromRight[len - 1] = len;

        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && height[p] >= height[i])
                p = lessFromRight[p];
            lessFromRight[i] = p;
        }

        /* Find the max area */
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int area = height[i] * (lessFromRight[i] - lessFromLeft[i] - 1);
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
