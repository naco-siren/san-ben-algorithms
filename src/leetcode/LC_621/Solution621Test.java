package leetcode.LC_621;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution621Test {

    @Test
    public void leastInterval_1() {
        assertEquals(6, new Solution621().leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
    }

    @Test
    public void leastInterval_2() {
        assertEquals(8, new Solution621().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    @Test
    public void leastInterval_3() {
        assertEquals(16, new Solution621().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    @Test
    public void leastInterval_4() {
        assertEquals(14, new Solution621().leastInterval(new char[]{'A','A','A','A','B','B','B','B','C','C','C','D','D','D'}, 2));
        // √: (A) B C D . (A) B C D . (A) B C D . (A) B
        // X: (A) B C . (A) B D . (A) C D . (A) B C B
    }
}