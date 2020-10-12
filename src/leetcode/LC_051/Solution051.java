package leetcode.LC_051;

import java.util.*;

/**
 * 51. N-Queens
 */
public class Solution051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new LinkedList<>();

        attempt(n, 0, new int[n], new int[n], new int[n * 2], new int[n * 2], results);

        return results;
    }

    private void attempt(
            final int n,
            final int row,
            int[] queens,
            int[] cols,
            int[] hills,
            int[] dales,
            List<List<String>> results) {

        // Complete after last row
        if (row == n) {
            results.add(format(queens));
            return;
        }

        for (int col = 0; col < n; col++) {
            // Skip attacked coordinates
            if (isAttacked(n, row, col, cols, hills, dales))
                continue;

            // Place queen
            placeOrRemoveQueen(true, n, row, col, queens, cols, hills, dales);

            // DFS
            attempt(n, row + 1, queens, cols, hills, dales, results);

            // Back track
            placeOrRemoveQueen(false, n, row, col, queens, cols, hills, dales);
        }
    }

    /**
     *
     * @param place
     * @param n
     * @param row
     * @param col
     * @param queens
     * @param cols
     * @param hills     PAY ATTENTION TO THIS PRESENTATION OF DIAGONAL LINES (i.e. /), where each slot has same `row + col`
     * @param dales     PAY ATTENTION TO THIS PRESENTATION OF DIAGONAL LINES (i.e. \), where each slot has same `row - col`
     */
    private void placeOrRemoveQueen(boolean place, int n, int row, int col, int[] queens, int[] cols, int[] hills, int[] dales) {
        queens[row] = place ? col : -1;
        cols[col] = place ? 1 : 0;
        hills[row + col] = place ? 1 : 0;           // ranging from `0` to `2 * (n - 1)`.
        dales[row - col + n] = place ? 1 : 0;       // ranging from `1 - n` to `n - 1`, therefore needs a `+ n` compensation for converting
    }

    private boolean isAttacked(int n, int row, int col, int[] cols, int[] hills, int[] dales) {
        int attacks = cols[col] + hills[row + col] + dales[row - col + n];
        return attacks > 0;
    }

    private List<String> format(int[] queens) {
        final int N = queens.length;
        List<String> result = new ArrayList<>(N);
        for (int col : queens) {
            char[] chars = new char[N];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';
            result.add(new String(chars));
        }
        return result;
    }
}
