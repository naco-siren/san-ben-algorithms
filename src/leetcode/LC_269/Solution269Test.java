package leetcode.LC_269;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution269Test {

    @Test
    public void alienOrder_0() {
        assertEquals("zx", new Solution269().alienOrder(new String[]{
                "z",
                "x"
        }));
    }

    @Test
    public void alienOrder_wtf_0() {
        assertEquals("z", new Solution269().alienOrder(new String[]{
                "z",
                "z"
        }));
    }

    @Test
    public void alienOrder_wtf_0_0() {
        assertEquals("ab", new Solution269().alienOrder(new String[]{
                "ab",
                "ab"
        }));
    }

    @Test
    public void alienOrder_1() {
        assertEquals("", new Solution269().alienOrder(new String[]{
                "abc",
                "ab"
        }));
    }

    @Test
    public void alienOrder_2() {
        assertEquals("wertf", new Solution269().alienOrder(new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        }));
    }

    @Test
    public void alienOrder_invalid_1() {
        assertEquals("", new Solution269().alienOrder(new String[]{
                "z",
                "x",
                "z"
        }));
    }
}