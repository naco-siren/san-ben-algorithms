package leetcode.LC_067;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution67Test {

    @Test
    public void addBinary_11_0() {
        assertEquals("11", new Solution67().addBinary("11", "0"));
    }

    @Test
    public void addBinary_10_1() {
        assertEquals("11", new Solution67().addBinary("10", "1"));
    }

    @Test
    public void addBinary_11_1() {
        assertEquals("100", new Solution67().addBinary("11", "1"));
    }

    @Test
    public void addBinary_11_11() {
        assertEquals("110", new Solution67().addBinary("11", "11"));
    }

    @Test
    public void addBinary_1010_1011() {
        assertEquals("10101", new Solution67().addBinary("1010", "1011"));
    }
}