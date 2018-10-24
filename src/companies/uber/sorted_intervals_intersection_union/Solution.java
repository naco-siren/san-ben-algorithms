package companies.uber.sorted_intervals_intersection_union;

import base.Interval;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        // TODO: To be implemented

        // 1--2  3--6  7---10  11-------15
        //        4-----8  9----12 13--14  16--18

        Interval[] intervals1 = new Interval[] {
                new Interval(1, 2),
                new Interval(3, 6),
                new Interval(7, 10),
                new Interval(11, 15)
        };
        Interval[] intervals2 = new Interval[] {
                new Interval(4, 8),
                new Interval(9, 12),
                new Interval(13, 14),
                new Interval(15, 16)
        };


        // 4--6  7--8  9--10  11--12  13--14
        Interval[] intersection = calcIntersection(intervals1, intervals2);

        // 1--2 3--15 16--18
        Interval[] union = calcUnion(intervals1, intervals2);
    }

    public static Interval[] calcIntersection(Interval[] intervals1, Interval[] intervals2) {
        return null;
    }

    public static Interval[] calcUnion(Interval[] intervals1, Interval[] intervals2) {
        LinkedList<Interval> result = new LinkedList<>();

        int i = 0, j = 0;
        Interval left, right;
        while (i < intervals1.length || j < intervals2.length) {
            left = intervals1[i];
            right = intervals2[j];


            if (left.end < right.start) {
                result.add(left);
                i++; continue;
            }
            if (right.end < left.start) {
                result.add(right);
                j++; continue;
            }


        }

        return null;
    }

}
