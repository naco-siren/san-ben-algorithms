package leetcode.LC_253;

import base.Interval;

import java.util.*;

/**
 * Given a list of intervals, find vacant intervals between them
 */
class Solution253FollowUp {
    List<Interval> findVacancies(Interval[] intervals) {
        LinkedList<Interval> vacantIntervals = new LinkedList<>();
        if (intervals == null || intervals.length == 0)
            return vacantIntervals;

        // Sort intervals in ascending order of their start times
        int count = intervals.length;
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1.start != i2.start)
                return i1.start - i2.start;
            else
                return i1.end - i2.end;
        });

        // Maintain a list of busy intervals to keep track of the earliest available time
        LinkedList<Interval> busyIntervals = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            final Interval interval = intervals[i];

            if (busyIntervals.isEmpty()) {
                busyIntervals.addLast(interval);
                continue;
            }

            final Interval latestBusy = busyIntervals.getLast();
            if (interval.start > latestBusy.end) {
                vacantIntervals.addLast(new Interval(latestBusy.end, interval.start));
                busyIntervals.addLast(interval);
            } else {
                latestBusy.end = Math.max(latestBusy.end, interval.end);
            }
        }

        return vacantIntervals;
    }

    public List<Interval> findVacancies(Interval[] intervals, int k) {
        int count = intervals.length;

        /* Convert intervals into sorted timestamps */
        ArrayList<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        points.sort((p1, p2) -> {
            if (p1.val != p2.val)
                return p1.val - p2.val;
            else {
                if (p1.isStart && !p2.isStart)
                    return 1;
                else if (!p1.isStart && p2.isStart)
                    return -1;
                else
                    return 0;
            }
        });


        /* Assign the number of rooms to each interval */
        LinkedList<int[]> list = new LinkedList<>();

        Integer lastPoint = null;
        int lastRooms = 0;

        for (int i = 0; i < points.size();) {
            /* Initialize status */
            int curRooms = lastRooms;

            /* All the events at this timestamp, calculate cur rooms */
            while (i < points.size() - 1 && points.get(i).val == points.get(i+1).val) {
                curRooms = points.get(i).isStart ? curRooms + 1 : curRooms - 1;
                i++;
            }
            curRooms = points.get(i).isStart ? curRooms + 1 : curRooms - 1;

            /* Check if a new interval is needed */
            if (lastPoint == null)
                lastPoint = points.get(i).val;
            else if (points.get(i).val > lastPoint)
                list.add(new int[]{lastPoint, points.get(i).val, lastRooms});

            /* Update status */
            lastRooms = curRooms;
            lastPoint = points.get(i).val;
            i++;
        }

        /* Filter out intervals with enough free rooms */
        ArrayList<Interval> results = new ArrayList<>(list.size());
        for (int[] interval : list)
            if (count - interval[2] >= k)
                results.add(new Interval(interval[0], interval[1]));

        /* Merge intervals */
        for (int i = 1; i < results.size();) {
            Interval cur = results.get(i);
            Interval last = results.get(i-1);

            if (cur.start == last.end) {
                last.end = cur.end;
                results.remove(i);
                results.set(i-1, last);
            } else {
                i++;
            }
        }

        return results;
    }

    static class Point {
        int val;
        boolean isStart;

        public Point(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            return "" + val + ", " + (isStart ? "s" : "e");
        }
    }
}

