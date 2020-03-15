package leetcode.LC_402;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static leetcode.LC_402.Solution.removeKdigits;

public class SolutionTest {

    @Test
    public void removeKdigits_10_2() {
        String r = removeKdigits("10", 2);
        assertEquals("0", r);
    }

    @Test
    public void removeKdigits_11221_2() {
        String r = removeKdigits("11221", 2);
        assertEquals("111", r);
    }

    @Test
    public void removeKdigits_1432219_3() {
        String r = removeKdigits("1432219", 3);
        assertEquals("1219", r);
    }

    @Test
    public void removeKdigits_10200_3() {
        String r = removeKdigits("10200", 1);
        assertEquals( "200", r);
    }

    @Test
    public void removeKdigits_100_1() {
        String r = removeKdigits("100", 1);
        assertEquals( "0", r);
    }

    @Test
    public void removeKdigits_112_1() {
        String r = removeKdigits("112", 1);
        assertEquals( "11", r);
    }
}
