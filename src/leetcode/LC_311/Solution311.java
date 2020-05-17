package leetcode.LC_311;

/**
 * 311. Sparse Matrix Multiplication
 */
class Solution311 {
    int[][] multiply(int[][] A, int[][] B) {
        // size(A) = x * y, size(B) = y * z
        final int x = A.length, y = A[0].length, z = B[0].length;

        int[][] result = new int[x][];
        for (int i = 0; i < x; i++) {
            result[i] = new int[z];
            for (int j = 0; j < y; j++) {
                // PAY ATTENTION TO THIS PRUNING:
                if (A[i][j] == 0)
                    continue;

                for (int k = 0; k < z; k++)
                    result[i][k] += A[i][j] * B[j][k];
            }

        }
        return result;
    }
}
