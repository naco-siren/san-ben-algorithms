package hackerrank;

/**
 * Created by naco_siren on 8/27/17.
 */
import java.io.*;
import java.util.*;

public class SpiralMatrix {
    public static void main(String args[] ) throws Exception {
        SpiralMatrix solution = new SpiralMatrix();
        solution.solve();
    }

    public void solve() {
        /* Initialize the matrix */
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt(), C = scanner.nextInt();
        int[][] matrix = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        /* Spiral */
        int count = 0; ArrayList<Integer> output = new ArrayList<>(R*C);
        for (int k = 0; k <= R-1-k && k <= C-1-k; k++) {
            /* First row from (left) to (right - 1) */
            for (int j = k; j < C-1-k; j++)
                output.add(matrix[k][j]);

            /* Break if only one row */
            if (k == R-1-k)
                output.add(matrix[k][C-1-k]);

            /* Last column from (top) to (bottom - 1) */
            for (int i = k; i < R-1-k; i++)
                output.add(matrix[i][C-1-k]);

            /* Break if only one column */
            if (k == C-1-k)
                output.add(matrix[R-1-k][C-1-k]);

            /* Last row from (right) to (left + 1) */
            for (int j = C-1-k; j > k; j--)
                output.add(matrix[R-1-k][j]);

            /* First column from (bottom) to (top + 1) */
            for (int i = R-1-k; i > k; i--)
                output.add(matrix[i][k]);
        }

        /* Output to STDOUT */
        for (int i = 0; i < R * C - 1; i++) {
            System.out.print(output.get(i));
            System.out.print(",");
        }
        System.out.print(output.get(R * C - 1));
    }
}