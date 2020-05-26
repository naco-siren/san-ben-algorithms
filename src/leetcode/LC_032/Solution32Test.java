package leetcode.LC_032;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution32Test {

    @Test
    public void longestValidParentheses_l_l_r() {
        assertEquals(2, new Solution32().longestValidParentheses("(()"));
    }

    @Test
    public void longestValidParentheses_r_l_r_l_r_r() {
        assertEquals(4, new Solution32().longestValidParentheses(")()())"));
    }

    @Test
    public void longestValidParentheses_r_l_l_l_r_r_r_l() {
        assertEquals(6, new Solution32().longestValidParentheses(")((()))("));
    }

}