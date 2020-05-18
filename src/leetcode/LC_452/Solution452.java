package leetcode.LC_452;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 */
class Solution452 {
    int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        int arrows = 1;
        int[] prevOverlapping = points[0];     // This range is the the last group of overlapping points.

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevOverlapping[1]) {
                arrows++;
                prevOverlapping = points[i];
            } else {
                prevOverlapping[0] = points[i][0];
                prevOverlapping[1] = Math.min(prevOverlapping[1], points[i][1]);
            }
        }
        return arrows;
    }

}
