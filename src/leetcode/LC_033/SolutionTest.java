package leetcode.LC_033;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void search_0() {
        assertEquals(-1, new Solution().search(new int[]{}, 6));
    }

    @Test
    public void search_1() {
        assertEquals(-1, new Solution().search(new int[]{1,3}, 0));
        assertEquals(0, new Solution().search(new int[]{1,3}, 1));
        assertEquals(1, new Solution().search(new int[]{1,3}, 3));
    }

    @Test
    public void search_2() {
        assertEquals(4, new Solution().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}