package leetcode.LC_286;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution286Test {
    private final static int INF = Integer.MAX_VALUE;

    @Test
    public void wallsAndGates() {
        final int[][] rooms = new int[][]{
                new int[]{INF,  -1,     0,      INF},
                new int[]{INF,  INF,    INF,    -1},
                new int[]{INF,  -1,     INF,    -1},
                new int[]{0,    -1,     INF,    INF}
        };

        new Solution286().wallsAndGates(rooms);

        assertArrayEquals(new int[]{3,  -1,  0,  1}, rooms[0]);
        assertArrayEquals(new int[]{2,  2,  1,  -1}, rooms[1]);
        assertArrayEquals(new int[]{1,  -1,  2,  -1}, rooms[2]);
        assertArrayEquals(new int[]{0,  -1,  3,  4}, rooms[3]);
    }
}