package leetcode.LC_977;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution977Test {

    @Test
    public void sortedSquares_pos_only() {
        assertArrayEquals(new int[]{1, 4, 9, 16, 25}, new Solution977().sortedSquares(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void sortedSquares_pos_with_zero() {
        assertArrayEquals(new int[]{0, 1, 4, 9, 16}, new Solution977().sortedSquares(new int[]{0, 1, 2, 3, 4}));
    }

    @Test
    public void sortedSquares_neg_only() {
        assertArrayEquals(new int[]{1, 4, 9, 16, 25}, new Solution977().sortedSquares(new int[]{-5, -4, -3, -2, -1}));
    }

    @Test
    public void sortedSquares_neg_with_zero() {
        assertArrayEquals(new int[]{0, 1, 4, 9, 16}, new Solution977().sortedSquares(new int[]{-4, -3, -2, -1, 0}));
    }

    @Test
    public void sortedSquares_neg_and_pos() {
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, new Solution977().sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }

    @Test
    public void sortedSquares_neg_and_pos_with_zero() {
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, new Solution977().sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }
}