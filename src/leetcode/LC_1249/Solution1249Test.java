package leetcode.LC_1249;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1249Test {

    @Test
    public void minRemoveToMakeValid_1() {
        assertEquals("lee(t(c)o)de" , new Solution1249().minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    @Test
    public void minRemoveToMakeValid_2() {
        assertEquals("ab(c)d" , new Solution1249().minRemoveToMakeValid("a)b(c)d"));
    }

    @Test
    public void minRemoveToMakeValid_3() {
        assertEquals("", new Solution1249().minRemoveToMakeValid("))(("));
    }
}