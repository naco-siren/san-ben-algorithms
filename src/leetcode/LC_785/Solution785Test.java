package leetcode.LC_785;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution785Test {

    @Test
    public void isBipartite_1() {
        /*
         * 0----1
         * |    |
         * |    |
         * 3----2
         */
        assertTrue(new Solution785().isBipartite(new int[][]{
                {1,3}, {0,2}, {1,3}, {0,2} 
        }));
    }

    @Test
    public void isBipartite_2() {
        /*
         * 0----1
         * | \  |
         * |  \ |
         * 3----2
         */
        assertFalse(new Solution785().isBipartite(new int[][]{
                {1,2,3}, {0,2}, {0,1,3}, {0,2}
        }));
    }

}