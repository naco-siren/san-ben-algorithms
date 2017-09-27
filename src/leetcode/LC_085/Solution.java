package leetcode.LC_085;

/**
 * Created by naco_siren on 7/18/17.
 */
public class Solution {
    public static void main(String[] args) {


        return;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0; int m = matrix.length;
        if (m == 0 || matrix[0] == null) return 0; int n = matrix[0].length;

        int maxArea = 0;
        int[] left = new int[n], right = new int[n], height = new int[n];
        for (int i = 0; i < n; i++)
            right[i] = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            /* Max index on the Left */
            int maxLeft = 0;
            for (int j = 0; j < n; j++) {
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
            int minRight = n-1;
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (minRight < right[j])
                        right[j] = minRight;

                    int newArea = height[j] * (right[j] - left[j] + 1);
                    if (newArea > maxArea)
                        maxArea = newArea;

                } else {
                    right[j] = n;
                    minRight = j - 1;
                }
            }
        }
        return maxArea;
    }
}
