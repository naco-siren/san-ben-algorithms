package leetcode.LC_253;

import base.Interval;

import java.util.*;

/**
 * Created by naco_siren on 10/1/17.
 */
public class FollowUp {
    public static void main(String[] args) {
        Interval[] input = new Interval[]{
                new Interval(1, 3),
                new Interval(2, 3),
                new Interval(2, 5),
                new Interval(3, 6),
                new Interval(6, 8),
                new Interval(9, 10),
//                new Interval(12, 13)
        };


//        List<Interval> r1 = findVacancies(input); // [(8, 9), (10, 12)] !
        List<Interval> r2 = findVacancies(input, 4); // [(1, 2), (3, 10)] !
        List<Interval> r3 = findVacancies(input, 5); // [(1, 2), (5, 10)] !



        return;
    }

    public static List<Interval> findVacancies(Interval[] intervals) {
        int count = intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start)
                    return i1.start - i2.start;
                else
                    return i1.end - i2.end;
            }
        });

        LinkedList<Interval> busyIntervals = new LinkedList<>();
        LinkedList<Interval> vacantIntervals = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            Interval cur = intervals[i];
            if (busyIntervals.isEmpty()) {
                busyIntervals.addLast(cur);

            } else {
                Interval old = busyIntervals.getLast();

                if (cur.start > old.end) {
                    vacantIntervals.addLast(new Interval(old.end, cur.start));
                    busyIntervals.addLast(cur);
                } else {
                    old.end = Math.max(old.end, cur.end);
                }
            }
        }

        return vacantIntervals;
    }


    public static List<Interval> findVacancies(Interval[] intervals, int k) {
        int count = intervals.length;

        /* Convert intervals into sorted timestamps */
        ArrayList<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
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
            }
        });


        /* Assign the number of rooms to each interval */
        LinkedList<int[]> list = new LinkedList<>();

        Integer lastPoint = points.get(0).val;
        int lastRooms = 1;
        for (int i = 1; i < points.size();) {
            /* Initialize status */
            int curRooms = lastRooms;

            /* All the events at this timestamp, calculate cur rooms */
            while (i < points.size() - 1 && points.get(i).val == points.get(i+1).val) {
                curRooms = points.get(i).isStart ? curRooms + 1 : curRooms - 1;
                i++;
            }
            curRooms = points.get(i).isStart ? curRooms + 1 : curRooms - 1;


            /* Check if a new interval is needed */
            if (points.get(i).val > lastPoint)
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
}

class Point {
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
