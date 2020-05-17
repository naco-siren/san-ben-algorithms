package leetcode.LC_304;

/**
 * 304. Range Sum Query 2D - Immutable
 */
class Solution304 {
    static class NumMatrix {
        int R;
        int C;
        int[][] matrix;
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            this.R = matrix.length;
            this.C = R > 0 ? matrix[0].length : 0;

            this.sums = new int[R][C+1];
            for (int i = 0; i < R; i++) {
                int sum = 0;
                for (int j = 0; j < C; j++) {
                    sum += matrix[i][j];
                    sums[i][j + 1] = sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += sums[i][col2 + 1] - sums[i][col1];
            }
            return sum;
        }
    }
}

