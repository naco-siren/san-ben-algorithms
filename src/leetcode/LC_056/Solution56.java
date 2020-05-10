package leetcode.LC_056;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 56. Merge Intervals
 */
class Solution56 {
    int[][] merge(int[][] intervals) {
        // Sort intervals by their "starts"
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        // Concatenate intervals upon overlapping
        Deque<int[]> merged = new LinkedList<>();
        for (final int[] cur : intervals) {
            if (!merged.isEmpty() && merged.peekLast()[1] >= cur[0]) {
                final int[] last = merged.pollLast();
                merged.offerLast(new int[]{last[0], Math.max(last[1], cur[1])});
            } else {
                merged.offerLast(cur);
            }
        }

        // Collect results
        int[][] result = new int[merged.size()][];
        merged.toArray(result);
        return result;
    }
}
