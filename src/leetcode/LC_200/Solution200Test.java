package leetcode.LC_200;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Solution200Test {

    @Test
    public void numIslands_1() {
        assertEquals(1, new Solution200().numIslands(new char[][]{
            new char[]{'1','1','1','1','0'},
            new char[]{'1','1','0','1','0'},
            new char[]{'1','1','0','0','0'},
            new char[]{'0','0','0','0','0'},
        }));
    }

    @Test
    public void numIslands_2() {
        assertEquals(3, new Solution200().numIslands(new char[][]{
            new char[]{'1','1','0','1','0'},
            new char[]{'1','1','0','1','0'},
            new char[]{'1','1','0','0','0'},
            new char[]{'0','0','0','1','0'},
        }));
    }

    @Test
    public void numIslands_3() {
        assertEquals(3, new Solution200().numIslands(new char[][]{
            new char[]{'1','1','1','1','0'},
            new char[]{'1','1','0','1','0'},
            new char[]{'1','1','0','0','1'},
            new char[]{'0','0','1','1','0'},
        }));
    }
}