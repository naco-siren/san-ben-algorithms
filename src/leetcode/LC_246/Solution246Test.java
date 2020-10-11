package leetcode.LC_246;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution246Test {

    @Test
    public void isStrobogrammatic_1() {
        assertTrue(new Solution246().isStrobogrammatic("1"));
    }

    @Test
    public void isStrobogrammatic_2() {
        assertFalse(new Solution246().isStrobogrammatic("2"));
    }

    @Test
    public void isStrobogrammatic_69() {
        assertTrue(new Solution246().isStrobogrammatic("69"));
    }

    @Test
    public void isStrobogrammatic_619() {
        assertTrue(new Solution246().isStrobogrammatic("619"));
    }

    @Test
    public void isStrobogrammatic_659() {
        assertFalse(new Solution246().isStrobogrammatic("659"));
    }
}