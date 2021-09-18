package leetcode.LC_163;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution163Test {

    @Test
    public void findMissingRanges_1() {
        List<String> valsList = new Solution163().findMissingRanges(new int[]{0,1,3,50,75}, 0, 99);
        String[] valsArray = new String[valsList.size()];
        valsList.toArray(valsArray);
        assertArrayEquals(new String[]{"2","4->49","51->74","76->99"}, valsArray);
    }

    @Test
    public void findMissingRanges_2() {
        List<String> valsList = new Solution163().findMissingRanges(new int[]{}, -3, -1);
        String[] valsArray = new String[valsList.size()];
        valsList.toArray(valsArray);
        assertArrayEquals(new String[]{"-3->-1"}, valsArray);
    }

    @Test
    public void findMissingRanges_3() {
        List<String> valsList = new Solution163().findMissingRanges(new int[]{-1}, -1, -1);
        String[] valsArray = new String[valsList.size()];
        valsList.toArray(valsArray);
        assertArrayEquals(new String[]{}, valsArray);
    }

    @Test
    public void findMissingRanges_4() {
        List<String> valsList = new Solution163().findMissingRanges(new int[]{-1}, -2, -1);
        String[] valsArray = new String[valsList.size()];
        valsList.toArray(valsArray);
        assertArrayEquals(new String[]{"-2"}, valsArray);
    }

    @Test
    public void formatPairs_0_1() {
        String val = new Solution163.Pair(0, 1).toString();
        assertNull(val);
    }

    @Test
    public void formatPairs_0_2() {
        String val = new Solution163.Pair(0, 2).toString();
        assertEquals("1", val);
    }

    @Test
    public void formatPairs_0_3() {
        String val = new Solution163.Pair(0, 3).toString();
        assertEquals("1->2", val);
    }

    @Test
    public void formatPairs_m3_m1() {
        String val = new Solution163.Pair(-3, -1).toString();
        assertEquals("-2", val);
    }

    @Test
    public void formatPairs_m4_m1() {
        String val = new Solution163.Pair(-4, -1).toString();
        assertEquals("-3->-2", val);
    }
}