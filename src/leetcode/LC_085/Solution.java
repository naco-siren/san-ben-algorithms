package leetcode.LC_085;

import java.util.Arrays;

/**
 * Created by naco_siren on 7/18/17.
 */
public class Solution {
    public static void main(String[] args) {

        int r1 = maximalRectangle(new char[][]{
                new char[]{'1','0','1','0','0'},
                new char[]{'1','0','1','1','1'},
                new char[]{'1','1','1','1','1'},
                new char[]{'1','0','0','1','0'},
        });

        return;
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0; int R = matrix.length;
        if (R == 0 || matrix[0] == null) return 0; int C = matrix[0].length;

        /* Initialize DP */
        int maxArea = 0;
        int[] left = new int[C], right = new int[C], height = new int[C];

        /* Remember to initialize rights with some really large numbers */
        Arrays.fill(right, C);

        /* DP */
        for (int i = 0; i < R; i++) {
            /* Max index on the Left */
            int maxLeft = 0;
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == '1') {
                    if (maxLeft > left[j])
                        left[j] = maxLeft;

                    height[j]++;

                } else {
                    left[j] = 0;
                    maxLeft = j + 1;

                    height[j] = 0;
                }
            }

            /* Min index on the Right */
            int minRight = C - 1;
            for (int j = C - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (minRight < right[j])
                        right[j] = minRight;

                    int newArea = height[j] * (right[j] - left[j] + 1);
                    if (newArea > maxArea)
                        maxArea = newArea;

                } else {
                    right[j] = C;
                    minRight = j - 1;
                }
            }
        }
        return maxArea;
    }
}
