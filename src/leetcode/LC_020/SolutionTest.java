package leetcode.LC_020;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isValid_0() {
        assertTrue(new Solution().isValid(""));
    }

    @Test
    public void isValid_1() {
        assertTrue(new Solution().isValid("()"));
    }

    @Test
    public void isValid_2() {
        assertTrue(new Solution().isValid("()[]{}"));
    }

    @Test
    public void isValid_3() {
        assertFalse(new Solution().isValid("(]"));
        assertFalse(new Solution().isValid("([)]"));
    }

    @Test
    public void isValid_4() {
        assertFalse(new Solution().isValid("("));
        assertFalse(new Solution().isValid("(["));
        assertFalse(new Solution().isValid("{{"));
    }

    @Test
    public void isValid_5() {
        assertFalse(new Solution().isValid("]"));
        assertFalse(new Solution().isValid("}]"));
    }
}