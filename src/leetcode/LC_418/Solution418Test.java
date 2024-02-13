package leetcode.LC_418;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution418Test {
    @Test
    public void sample_0() {
        assertEquals(1, new Solution418().wordsTyping(new String[]{"Hello", "World"}, 2, 8));
    }

    @Test
    public void sample_1() {
        assertEquals(2, new Solution418().wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
    }

    @Test
    public void sample_2() {
        assertEquals(1, new Solution418().wordsTyping(new String[]{"i","had","apple","pie"}, 4, 5));
    }
}
