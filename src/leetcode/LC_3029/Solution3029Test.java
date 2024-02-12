package leetcode.LC_3029;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution3029Test {

    @Test
    public void sampleCase_0() {
        assertEquals(2,  new Solution3029().minimumTimeToInitialState("abacaba", 3));
    }

    @Test
    public void sampleCase_1() {
        assertEquals(1,  new Solution3029().minimumTimeToInitialState("abacaba", 4));
    }

    @Test
    public void sampleCase_2() {
        assertEquals(4,  new Solution3029().minimumTimeToInitialState("abcbabcd", 2));
    }
}
