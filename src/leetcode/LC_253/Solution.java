package leetcode.LC_253;

import base.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by naco_siren on 9/18/17.
 */
public class Solution {
    public static void main(String[] args) {
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(2, 3);
        Interval i3 = new Interval(2, 4);
        Interval i4 = new Interval(3, 5);
        Interval[] input = new Interval[]{i1, i2, i3, i4};

        Solution lc = new Solution();
        int output1 = lc.minMeetingRooms1(input);
        int output2 = lc.minMeetingRooms2(input);


        return;
    }

    public static int minMeetingRooms1(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int rooms = 0;
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (ends.isEmpty() || interval.start < ends.peek()) {
                rooms++;
                ends.offer(interval.end);
            } else {
                ends.poll();
                ends.offer(interval.end);
            }
        }
        return rooms;
    }


    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        /* Sort the times into an array with labels */
        Time[] times = new Time[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            times[i * 2] = new Time(intervals[i].start, true);
            times[i * 2 + 1] = new Time(intervals[i].end, false);
        }
        Arrays.sort(times, new Comparator<Time>(){
            @Override
            public int compare(Time t1, Time t2) {
                int diff = t1.time - t2.time;
                if (diff == 0) {
                    if (t1.isStart && t2.isStart)
                        return 0;
                    else if (!t1.isStart && t2.isStart)
                        return -1;
                    else if (t1.isStart && !t2.isStart)
                        return 1;
                    else
                        return 0;
                } else {
                    return diff;
                }
            }
        });

        /* Process the times one by one */
        int maxRooms = 0;
        int rooms = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i].isStart) {
                rooms++;
                if (rooms > maxRooms) maxRooms = rooms;
            } else {
                rooms--;
            }
        }

        return maxRooms;
    }

}
