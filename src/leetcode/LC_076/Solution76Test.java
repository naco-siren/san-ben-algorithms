package leetcode.LC_076;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution76Test {

    @Test
    public void minWindow_a_a() {
        assertEquals("a",  new Solution76().minWindow("a", "a"));
    }

    @Test
    public void minWindow_ADOBECODEBANC_ABC() {
        assertEquals("BANC",  new Solution76().minWindow("ADOBECODEBANC", "ABC"));
    }
}