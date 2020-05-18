package leetcode.LC_406;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution406Test {

    @Test
    public void reconstructQueue_empty() {
        final int[][] input = new int[][]{};
        final int[][] output = new int[][]{};
        assertArrayEquals(output, new Solution406().reconstructQueue(input));
    }

    @Test
    public void reconstructQueue_single() {
        final int[][] input = new int[][]{{7,0}};
        final int[][] output = new int[][]{{7,0}};
        assertArrayEquals(output, new Solution406().reconstructQueue(input));
    }

    @Test
    public void reconstructQueue_1() {
        final int[][] input = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        final int[][] output = new int[][]{{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        assertArrayEquals(output, new Solution406().reconstructQueue(input));
    }
}