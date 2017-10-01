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
                new Interval(2, 4),
                new Interval(2, 5),
                new Interval(3, 6),
                new Interval(6, 8),
                new Interval(9, 10),
                new Interval(12, 13)
        };


        List<Interval> r1 = findVacancies(input); // [(8, 9), (10, 12)] !



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
}
