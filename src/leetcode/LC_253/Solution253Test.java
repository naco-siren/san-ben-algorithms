package leetcode.LC_253;

import base.Interval;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution253Test {

    @Test
    public void minMeetingRooms1_0() {
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(2, 3);
        Interval i3 = new Interval(2, 4);
        Interval i4 = new Interval(3, 5);
        Interval[] input = new Interval[]{i1, i2, i3, i4};

        assertEquals(2, new Solution253().minMeetingRooms1(input));
        assertEquals(2, new Solution253().minMeetingRooms2(input));
    }
}