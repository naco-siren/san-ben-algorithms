package leetcode.LC_301;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Solution301Test {

    @Test
    public void removeInvalidParentheses_1() {
        List<String> result = new Solution301().removeInvalidParentheses(")(");

        List<String> expected = Arrays.asList("");
        assertEquals(expected.size(), result.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(result));
    }

    @Test
    public void removeInvalidParentheses_2() {
        List<String> result = new Solution301().removeInvalidParentheses("()())");

        List<String> expected = Arrays.asList("()()", "(())");
        assertEquals(expected.size(), result.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(result));
    }

    @Test
    public void removeInvalidParentheses_3() {
        List<String> result = new Solution301().removeInvalidParentheses("()())()");

        List<String> expected = Arrays.asList("(())()","()()()");
        assertEquals(expected.size(), result.size());
        assertEquals(new HashSet<>(expected), new HashSet<>(result));
    }

}