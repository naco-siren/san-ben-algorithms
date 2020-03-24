package leetcode.LC_1057;

import java.util.*;

/**
 * 1057. Campus Bikes
 */
public class Solution {
    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        int W = workers.length, B = bikes.length;

        // Sort all distances into 2001 buckets
        List<int[]>[] buckets = new ArrayList[2001];
        for (int i = 0; i < W; i++) {
            final int[] worker = workers[i];
            for (int j = 0; j < B; j++) {
                final int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                if (buckets[dist] == null) {
                    buckets[dist] = new ArrayList<>();
                }
                buckets[dist].add(new int[]{i, j});
            }
        }

        // Collect result from buckets
        int[] result = new int[W];
        Arrays.fill(result, -1);
        Set<Integer> usedBikes = new HashSet<>();
        for (int i = 0; i < 2001; i++) {
            if (buckets[i] == null)
                continue;

            for (int[] pair : buckets[i]) {
                int worker = pair[0], bike = pair[1];
                if (!usedBikes.contains(bike) && result[worker] == -1) {
                    result[worker] = bike;
                    usedBikes.add(bike);
                }
                if (usedBikes.size() == B) {
                    return result;
                }
            }
        }
        return result;
    }
}
