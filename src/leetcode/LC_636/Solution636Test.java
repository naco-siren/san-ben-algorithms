package leetcode.LC_636;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution636Test {

    @Test
    public void exclusiveTime_0() {
        assertArrayEquals(
                new int[]{1},
                new Solution636().exclusiveTime(
                        1,
                        Arrays.asList("0:start:0","0:end:0")));
    }

    @Test
    public void exclusiveTime_1() {
        assertArrayEquals(
                new int[]{3,4},
                new Solution636().exclusiveTime(
                        2,
                        Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6")));
    }

    @Test
    public void exclusiveTime_2() {
        assertArrayEquals(
                new int[]{8},
                new Solution636().exclusiveTime(
                        1,
                        Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7")));
    }

    @Test
    public void exclusiveTime_3() {
        assertArrayEquals(
                new int[]{7,1},
                new Solution636().exclusiveTime(
                        2,
                        Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7")));
    }

    @Test
    public void exclusiveTime_4() {
        assertArrayEquals(
                new int[]{8,1},
                new Solution636().exclusiveTime(
                        2,
                        Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8")));
    }

}