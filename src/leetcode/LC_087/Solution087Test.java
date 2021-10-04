package leetcode.LC_087;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution087Test {
    @Test
    public void a_a() {
         assertTrue(new Solution087().isScramble("a", "a"));
    }

    @Test
    public void abb_bba() {
        assertTrue(new Solution087().isScramble("abb", "bba"));
    }

    @Test
    public void great_rgate() {
        assertTrue(new Solution087().isScramble("great", "rgate"));
    }

}