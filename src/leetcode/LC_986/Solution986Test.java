package leetcode.LC_986;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution986Test {

    @Test
    public void intervalIntersection_1() {
        int[][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}}; 
        int[][] B = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] ans = new int[][]{{1,2},{5,5},{8,10},{15,23},{24,24},{25,25}};
        assertArrayEquals(ans, new Solution986().intervalIntersection(A, B));
    }
}