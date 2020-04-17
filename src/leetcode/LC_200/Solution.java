package leetcode.LC_200;

import java.util.Stack;

/**
 * 200. Number of Islands
 */
class Solution {
    public static int numIslands(char[][] grid) {
        // Validate input
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        final int R = grid.length, C = grid[0].length;

        // Flooding algorithm
        int islandCount = 0;
        Stack<Point> stack = new Stack<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] != '1')
                    continue;
                final int islandIdx = islandCount + 2;

                // Push current coordinate into stack
                grid[r][c] = (char) ('0' + islandIdx);
                stack.push(new Point(r, c));

                // Flood out
                while (!stack.isEmpty()) {
                    final Point point = stack.pop();
                    int rr = point.row, cc = point.col;
                    if (rr > 0 && grid[rr - 1][cc] == '1') {
                        grid[rr - 1][cc] = (char) ('0' + islandIdx);
                        stack.push(new Point(rr - 1, cc));
                    }
                    if (rr < R - 1 && grid[rr + 1][cc] == '1') {
                        grid[rr + 1][cc] = (char) ('0' + islandIdx);
                        stack.push(new Point(rr + 1, cc));
                    }
                    if (cc > 0 && grid[rr][cc - 1] == '1') {
                        grid[rr][cc - 1] = (char) ('0' + islandIdx);
                        stack.push(new Point(rr, cc - 1));
                    }
                    if (cc < C - 1 && grid[rr][cc + 1] == '1') {
                        grid[rr][cc + 1] = (char) ('0' + islandIdx);
                        stack.push(new Point(rr, cc + 1));
                    }
                }

                islandCount++;
            }
        }
        return islandCount;
    }

    /**
     * A better optimization is to avoid using `Point` class that leads to boxing & unboxing,
     * but instead adopt an encoding approach, i.e. `int id = r * cols + col; int r = id / cols, c = id % cols`
     *
     * Upon that, take advantage of the JVM stack frames to replace the `Stack` data structure extended from `Vector`.
     */
    static class Point{
        final int row;
        final int col;

        Point(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}



