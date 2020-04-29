package leetcode.LC_091;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution91Test {

    @Test
    public void numDecodings_0() {
        assertEquals(0, new Solution91().numDecodings("0"));
    }

    @Test
    public void numDecodings_9() {
        assertEquals(1, new Solution91().numDecodings("9"));
    }

    @Test
    public void numDecodings_12() {
        assertEquals(2, new Solution91().numDecodings("12"));
    }

    @Test
    public void numDecodings_122() {
        assertEquals(3, new Solution91().numDecodings("122"));
    }

    @Test
    public void numDecodings_120() {
        assertEquals(1, new Solution91().numDecodings("120"));
    }

    @Test
    public void numDecodings_226() {
        assertEquals(3, new Solution91().numDecodings("226"));
    }

    @Test
    public void numDecodings_99() {
        assertEquals(1, new Solution91().numDecodings("99"));
    }

    @Test
    public void numDecodings_105() {
        assertEquals(1, new Solution91().numDecodings("105"));
    }

}