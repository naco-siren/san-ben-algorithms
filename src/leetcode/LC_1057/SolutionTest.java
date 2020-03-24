package leetcode.LC_1057;

import org.junit.Test;

import static leetcode.LC_1057.Solution.assignBikes;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void assignBikes_0() {
        int[] result = assignBikes(new int[][]{{0, 0}, {2, 1}}, new int[][]{{1, 2}, {3, 3}});
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    public void assignBikes_1() {
        int[] result = assignBikes(new int[][]{{0,0},{1,1},{2,0}}, new int[][]{{1,0},{2,2},{2,1}});
        assertEquals(3, result.length);
        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
        assertEquals(1, result[2]);
    }
}