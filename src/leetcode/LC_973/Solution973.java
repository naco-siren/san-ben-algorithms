package leetcode.LC_973;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 */
class Solution973 {
    int[][] kClosest(int[][] points, int K) {
        // Validate input
        if (K > points.length)
            throw new IllegalArgumentException("K must not exceed the size of points!");

        // Construct a min heap with the given points
        PriorityQueue<Point> pq = new PriorityQueue<>(
                new Comparator<Point>() {
                    @Override
                    public int compare(Point p1, Point p2) {
                        return p1.x * p1.x + p1.y * p1.y - p2.x * p2.x - p2.y * p2.y;
                    }
                }
        );
        for (int[] point : points)
            pq.offer(new Point(point[0], point[1]));

        // Poll the K min points
        int[][] results = new int[K][];
        for (int i = 0; i < K; i++) {
            final Point point = pq.poll();
            results[i] = new int[]{point.x, point.y};
        }
        return results;
    }

    static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


