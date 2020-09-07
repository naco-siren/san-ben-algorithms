package leetcode.LC_528;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution528Test {

    private final static int REPEAT_COUNT = 1_000_000;

    @Test
    public void pickIndex_1_3() {
        final int[] w = new int[]{1, 3};
        Solution528 solution = new Solution528(w);

        int[] histogram = new int[w.length];
        for (int i = 0; i < REPEAT_COUNT; i++) {
            histogram[solution.pickIndex()]++;
        }
    }
}