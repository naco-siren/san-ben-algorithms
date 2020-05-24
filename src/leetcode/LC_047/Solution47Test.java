package leetcode.LC_047;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution47Test {

    @Test
    public void permuteUnique_1_1_2() {
        List<List<Integer>> result = new Solution47().permuteUnique(new int[]{1, 1, 2});

        Integer[][] expected = new Integer[][]{
                {1,1,2},
                {1,2,1},
                {2,1,1}
        };

        assertEquals(expected.length, result.size());
        for (int i = 0; i < expected.length; i++) {
            Integer[] arr = new Integer[expected[i].length];
            result.get(i).toArray(arr);
            assertArrayEquals(expected[i], arr);
        }
    }

    @Test
    public void permuteUnique_1_1_2_3() {
        List<List<Integer>> result = new Solution47().permuteUnique(new int[]{1, 1, 2, 3});

        Integer[][] expected = new Integer[][]{
                {1,1,2,3},
                {1,1,3,2},
                {1,2,1,3},
                {1,2,3,1},
                {1,3,1,2},
                {1,3,2,1},
                {2,1,1,3},
                {2,1,3,1},
                {2,3,1,1},
                {3,1,1,2},
                {3,1,2,1},
                {3,2,1,1},
        };

        assertEquals(expected.length, result.size());
        for (int i = 0; i < expected.length; i++) {
            Integer[] arr = new Integer[expected[i].length];
            result.get(i).toArray(arr);
            assertArrayEquals(expected[i], arr);
        }
    }
}