package leetcode.LC_042;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution42Test {

    @Test
    public void trap_1() {
        assertEquals(6, new Solution42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}