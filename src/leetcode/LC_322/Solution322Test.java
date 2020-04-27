package leetcode.LC_322;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution322Test {

    @Test
    public void coinChange_0() {
        assertEquals(1, new Solution322().coinChange(new int[]{2}, 2));
    }

    @Test
    public void coinChange_1() {
        assertEquals(-1, new Solution322().coinChange(new int[]{2}, 3));
    }

    @Test
    public void coinChange_2() {
        assertEquals(3, new Solution322().coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    public void coinChange_555() {
        assertEquals(30, new Solution322().coinChange(new int[]{470,35,120,81,121}, 9825));
    }

    @Test
    public void coinChange_666() {
        assertEquals(66, new Solution322().coinChange(new int[]{281,20,251,251}, 7323));
    }
}