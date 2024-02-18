package leetcode.LC_694;

import java.util.*;

/**
 * 694. Number of Distinct Islands
 */
public class Solution694 {
    private static final int PROBE_OPTIONS = 4;
    private static final int[][] PROBE_DIFFS = new int[][] {
            new int[]{0, -1},   // Left
            new int[]{0, 1},    // Right
            new int[]{-1, 0},   // Up
            new int[]{1, 0},    // Down
    };
    private static final char[] PROBE_NAMES = new char[]{'L', 'R', 'U', 'D'};
    private static final char BACKTRACK_NAME = '_';

    public int numDistinctIslands(int[][] grid) {
        final int R = grid.length, C = grid[0].length;

        Set<String> islandSet = new HashSet<>();

        // Visited matrix
        boolean[][] visited = new boolean[R][];
        for (int r = 0; r < R; r++)
            visited[r] = new boolean[C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (visited[r][c] || grid[r][c] == 0)
                    continue;

                // Flooding via BFS
                Queue<Coordinates> queue = new LinkedList<>();
                visited[r][c] = true;
                queue.offer(new Coordinates(r, c));

                // Memorize the shape via the trace???
                StringBuilder trace = new StringBuilder();
                trace.append('o'); // i.e. origin

                while (!queue.isEmpty()) {
                    final Coordinates coord = queue.poll();
                    final int r1 = coord.row, c1 = coord.col;

                    for (int i = 0; i < PROBE_OPTIONS; i++) {
                        final int[] diff = PROBE_DIFFS[i];
                        final int r2 = r1 + diff[0], c2 = c1 + diff[1];

                        if (r2 < 0 || r2 >= R || c2 < 0 || c2 >= C
                                || visited[r2][c2] || grid[r2][c2] == 0)
                            continue;

                        visited[r2][c2] = true;
                        queue.offer(new Coordinates(r2, c2));
                        trace.append(PROBE_NAMES[i]);
                    }
                    trace.append(BACKTRACK_NAME);
                }
                islandSet.add(trace.toString());
            }
        }
        return islandSet.size();
    }

    private static class Coordinates {
        int row;
        int col;

        Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
