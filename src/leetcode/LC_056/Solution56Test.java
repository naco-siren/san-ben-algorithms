package leetcode.LC_056;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution56Test {

    @Test
    public void merge_1() {
        final int[][] merged = new Solution56().merge(new int[][]{
                new int[]{1,3}
        });

        assertEquals(1, merged.length);
        assertArrayEquals(new int[]{1,3}, merged[0]);
    }

    @Test
    public void merge_1_unsorted() {
        final int[][] merged = new Solution56().merge(new int[][]{
                new int[]{1,4},
                new int[]{0,4},
        });

        assertEquals(1, merged.length);
        assertArrayEquals(new int[]{0,4}, merged[0]);
    }

    @Test
    public void merge_2_concat() {
        final int[][] merged = new Solution56().merge(new int[][]{
                new int[]{1,4},
                new int[]{1,5}
        });

        assertEquals(1, merged.length);
        assertArrayEquals(new int[]{1,5}, merged[0]);
    }

    @Test
    public void merge_2_included() {
        final int[][] merged = new Solution56().merge(new int[][]{
                new int[]{1,4},
                new int[]{2,3}
        });

        assertEquals(1, merged.length);
        assertArrayEquals(new int[]{1,4}, merged[0]);
    }

    @Test
    public void merge_3_mix() {
        final int[][] merged = new Solution56().merge(new int[][]{
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8,10},
                new int[]{12,20},
                new int[]{15,18},
        });

        assertEquals(3, merged.length);
        assertArrayEquals(new int[]{1,6}, merged[0]);
        assertArrayEquals(new int[]{8,10}, merged[1]);
        assertArrayEquals(new int[]{12,20}, merged[2]);
    }
}