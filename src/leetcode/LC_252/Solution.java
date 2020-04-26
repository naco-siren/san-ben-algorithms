package leetcode.LC_252;

import java.util.Arrays;

/**
 * 252. Meeting Rooms
 */
class Solution {
    boolean canAttendMeetings(int[][] intervals) {
        // Early return on edge cases
        if (intervals == null || intervals.length == 0)
            return true;

        // Sort intervals in ascending order based on their start times
        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[1] - i2[1]);

        // Go through the ascending array to see if conflicts happen
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[i - 1][1])
                return false;
        }
        return true;
    }
}
