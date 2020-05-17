package leetcode.LC_253;

import base.Interval;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution253FollowUpTest {

    @Test
    public void findVacancies_0() {
        Interval[] input = new Interval[]{
                new Interval(1, 3),
                new Interval(2, 3),
                new Interval(2, 5),
                new Interval(3, 6),
                new Interval(6, 8),
                new Interval(9, 10),
//                new Interval(12, 13)
        };


//        List<Interval> r1 = new Solution253FollowUp().findVacancies(input); // [(8, 9), (10, 12)] !
//        assertEquals(2, r1.size());
//        assertEquals(new Interval(8, 9), r1.get(0));
//        assertEquals(new Interval(10, 12), r1.get(1));

        List<Interval> r2 = new Solution253FollowUp().findVacancies(input, 4); // [(1, 2), (3, 10)] !
        assertEquals(2, r2.size());
        assertEquals(new Interval(1, 2), r2.get(0));
        assertEquals(new Interval(3, 10), r2.get(1));

        List<Interval> r3 = new Solution253FollowUp().findVacancies(input, 5); // [(1, 2), (5, 10)] !
        assertEquals(2, r3.size());
        assertEquals(new Interval(1, 2), r3.get(0));
        assertEquals(new Interval(5, 10), r3.get(1));
    }
}