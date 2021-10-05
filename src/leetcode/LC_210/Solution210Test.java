package leetcode.LC_210;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution210Test {
    @Test
    public void findOrder_0() {
        int[] result = new Solution210().findOrder(1, new int[][]{});
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    public void findOrder_1() {
        int[] result = new Solution210().findOrder(2, new int[][]{ {1, 0} });
        assertArrayEquals(new int[]{0, 1}, result);
    }
    
    @Test
    public void findOrder_2() {
        int[] result = new Solution210().findOrder(4, new int[][]{ {1,0},{2,0},{3,1},{3,2} });

        assertTrue(Arrays.equals(new int[]{0, 1, 2, 3}, result)
                || Arrays.equals(new int[]{0, 2, 1, 3}, result)
        );
    }

}