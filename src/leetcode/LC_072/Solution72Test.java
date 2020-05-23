package leetcode.LC_072;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution72Test {

    @Test
    public void minEditDist_abc_bcd() {
        assertEquals(2, new Solution72().minDistance("abc", "bcd"));
    }

    @Test
    public void minEditDist_horse_ros() {
        assertEquals(3, new Solution72().minDistance("horse", "ros"));
    }

    @Test
    public void minEditDist_intention_execution() {
        assertEquals(5, new Solution72().minDistance("intention", "execution"));
    }
}