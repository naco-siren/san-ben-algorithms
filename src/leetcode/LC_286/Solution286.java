package leetcode.LC_286;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. Walls and Gates
 */
class Solution286 {
    public void wallsAndGates(int[][] rooms) {
        // Validate input
        if (rooms.length == 0 || rooms[0].length == 0)
            return;

        final int R = rooms.length, C = rooms[0].length;


        // Initialize a queue with GATES
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (rooms[i][j] == 0)
                    queue.offer(new Point(i, j, 0));

        // Flood out
        while (!queue.isEmpty()) {
            final Point point = queue.poll();
            final int x = point.x, y = point.y, depth = point.depth;

            if (x > 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
                rooms[x - 1][y] = depth + 1;
                queue.offer(new Point(x - 1, y, depth + 1));
            }

            if (x < R - 1 && rooms[x + 1][y] == Integer.MAX_VALUE) {
                rooms[x + 1][y] = depth + 1;
                queue.offer(new Point(x + 1, y, depth + 1));
            }

            if (y > 0 && rooms[x][y - 1] == Integer.MAX_VALUE) {
                rooms[x][y - 1] = depth + 1;
                queue.offer(new Point(x, y - 1, depth + 1));
            }

            if (y < C - 1 && rooms[x][y + 1] == Integer.MAX_VALUE) {
                rooms[x][y + 1] = depth + 1;
                queue.offer(new Point(x, y + 1, depth + 1));
            }
        }
    }

    static class Point {
        final int x;
        final int y;
        final int depth;

        Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}