package leetcode.LC_076;

import org.junit.Test;

import static leetcode.LC_076.Solution.minWindow;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minWindow_0() {
        assertEquals("a",  minWindow("a", "a"));
    }

    @Test
    public void minWindow_1() {
        assertEquals("BANC",  minWindow("ADOBECODEBANC", "ABC"));
    }
}