package leetcode.LC_716;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution716Test {

    @Test
    public void test_0() {
        Solution716 stack = new Solution716();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        assertEquals(5, stack.top());
        assertEquals(5, stack.popMax());
        assertEquals(1, stack.top());
        assertEquals(5, stack.peekMax());
        assertEquals(1, stack.pop());
        assertEquals(5, stack.top());
    }
}