package leetcode.LC_953;

import org.junit.Test;

import static leetcode.LC_953.Solution953.inOrder;
import static leetcode.LC_953.Solution953.isAlienSorted;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution953Test {

    private final static String DEFAULT_INDEX = "abcdefghijklmnopqrstuvwxyz";

    @Test
    public void inOrder_same() {
        assertTrue(inOrder(
                Solution953.constructIndex(DEFAULT_INDEX),
                "a",
                "a"
        ));
    }

    @Test
    public void inOrder_diff() {
        assertFalse(inOrder(
                Solution953.constructIndex(DEFAULT_INDEX),
                "b",
                "a"
        ));
    }

    @Test
    public void inOrder_samePrefix() {
        assertFalse(inOrder(
                Solution953.constructIndex(DEFAULT_INDEX),
                "abc",
                "ab"
        ));
    }

    @Test
    public void isAlienSorted_0() {
        assertTrue(isAlienSorted(
                new String[]{"hello","leetcode"},
                "hlabcdefgijkmnopqrstuvwxyz"));
    }

    @Test
    public void isAlienSorted_1() {
        assertFalse(isAlienSorted(
                new String[]{"word","world","row"},
                "worldabcefghijkmnpqstuvxyz"));
    }

    @Test
    public void isAlienSorted_2() {
        assertFalse(isAlienSorted(
                new String[]{"apple","app"},
                "abcdefghijklmnopqrstuvwxyz"));
    }
}