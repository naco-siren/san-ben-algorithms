package leetcode.LC_317;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 317. Shortest Distance from All Buildings
 */
public class Solution317 {
    /**
     *
     * Time: (m * n) * BFS = O(m*n * m*n)
     * Space: Memo (m x n) + BFS queue (2 * (m + n)) = O(m * n)
     *
     * Note the space complexity of BFS queue is not O(m * n), because:
     *   o o o o o o
     * o x x x x x x o
     *   o o o o o x o
     *           o x o
     *           o x o
     *           o x o
     *           o x o
     *           o x o
     *           o x o
     *           o x o
     *             o
     */
    int shortestDistance(int[][] grid) {
        // Preprocess the matrix to obtain size and buildings' count
        final int R = grid.length, C = grid[0].length;
        int B = 0;
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (grid[r][c] == 1)
                    B++;

        // Perform BFS from each valid location
        int minDist = Integer.MAX_VALUE;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1 || grid[r][c] == 2)
                    continue;

                // State
                int found = 0;
                int steps = 0;

                // BFS queue
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{r, c, 0});

                // Memorize visited coordinates
                boolean[][] visited = new boolean[R][C];
                visited[r][c] = true;

                while (!queue.isEmpty()) {
                    int[] step = queue.poll();
                    final int rr = step[0], cc = step[1], depth = step[2];

                    if (grid[rr][cc] == 1) {
                        found += 1;
                        steps += depth;
                        continue;
                    }

                    if (rr > 0 && grid[rr - 1][cc] != 2 && !visited[rr - 1][cc]) {
                        queue.offer(new int[]{rr - 1, cc, depth + 1});
                        visited[rr - 1][cc] = true;
                    }
                    if (rr < R - 1 && grid[rr + 1][cc] != 2 && !visited[rr + 1][cc]) {
                        queue.offer(new int[]{rr + 1, cc, depth + 1});
                        visited[rr + 1][cc] = true;
                    }
                    if (cc > 0 && grid[rr][cc - 1] != 2 && !visited[rr][cc - 1]) {
                        queue.offer(new int[]{rr, cc - 1, depth + 1});
                        visited[rr][cc - 1] = true;
                    }
                    if (cc < C - 1 && grid[rr][cc + 1] != 2 && !visited[rr][cc + 1]) {
                        queue.offer(new int[]{rr, cc + 1, depth + 1});
                        visited[rr][cc + 1] = true;
                    }
                }

                if (found == B)
                    minDist = Math.min(steps, minDist);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
