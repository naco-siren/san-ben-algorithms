package companies.uber.shortest_distance_2d;

import base.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] map1 = new int[][]{
                new int[]{0, 0, 0,  0, 0},
                new int[]{0, 1, 1,  0, 0},
                new int[]{0, 1, 0, -1, 0},
                new int[]{1, 0, 1,  1, 0},
        };

        int[][] r1 = solution.shortestDistance(map1);
    }

    private boolean validateMap(final int[][] map) {
        // Details omitted
        return true;
    }

    public int[][] shortestDistance(final int[][] map){
        if (!validateMap(map))
            throw new IllegalArgumentException("Input map invalid!");
        int R = map.length, C = map[0].length;

        // Initialize result 2D array; Locate start point
        int[][] result = new int[R][];
        int startR = -1, startC = -1;
        for (int i = 0; i < R; i++) {
            result[i] = new int[C];
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    startR = i;
                    startC = j;
                }
                result[i][j] = -1;
            }
        }

        // Perform a BFS
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startR, startC, 0));

        int r, c, depth;
        while (!queue.isEmpty()) {
            // Poll current point
            Point point = queue.poll();
            r = point.r;
            c = point.c;
            depth = point.depth;

            // Skip this point if already checked
            if (result[r][c] != -1 || map[r][c] == 1)
                continue;

            // Mark current depth; flood to four directions
            result[r][c] = depth;

            if (r-1 >= 0) queue.offer(new Point(r-1, c, depth + 1));
            if (r+1 < R) queue.offer(new Point(r+1, c, depth + 1));
            if (c-1 >= 0) queue.offer(new Point(r, c-1, depth + 1));
            if (c+1 < C) queue.offer(new Point(r, c+1, depth + 1));
        }

        return result;
    }

    static class Point {
        int r;
        int c;
        int depth;

        Point(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}
