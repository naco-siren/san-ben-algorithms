package leetcode.LC_039;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution39Test {

    @Test
    public void combinationSum_1() {
        List<List<Integer>> results = new Solution39().combinationSum(new int[]{2,3,6,7}, 7);
        assertEquals(2, results.size());

        Integer[] r1 = new Integer[results.get(0).size()];
        assertArrayEquals(new Integer[]{2, 2, 3}, results.get(0).toArray(r1));

        Integer[] r2 = new Integer[results.get(1).size()];
        assertArrayEquals(new Integer[]{7}, results.get(1).toArray(r2));
    }

    @Test
    public void combinationSum_2() {
        List<List<Integer>> results = new Solution39().combinationSum(new int[]{2,3,5}, 8);
        assertEquals(3, results.size());

        Integer[] r1 = new Integer[results.get(0).size()];
        assertArrayEquals(new Integer[]{2, 2, 2, 2}, results.get(0).toArray(r1));

        Integer[] r2 = new Integer[results.get(1).size()];
        assertArrayEquals(new Integer[]{2, 3, 3}, results.get(1).toArray(r2));

        Integer[] r3 = new Integer[results.get(2).size()];
        assertArrayEquals(new Integer[]{3, 5}, results.get(2).toArray(r3));
    }
}