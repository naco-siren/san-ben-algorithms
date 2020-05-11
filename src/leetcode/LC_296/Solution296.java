package leetcode.LC_296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 296. Best Meeting Point
 */
class Solution296 {
    int minTotalDistance(int[][] grid) {
        // Find the start points' row indices and column indices
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        int row = rows.get(rows.size() / 2);

        // Columns are not guaranteed to be monotone,
        // because the outer loop is row while inner loop is column
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);

        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points)
            distance += Math.abs(point - origin);
        return distance;
    }
}
