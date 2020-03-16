package leetcode.LC_1066;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void shortestWay_abc_abcbc_2() {
        Solution solution = new Solution();
        assertEquals(2, solution.shortestWay("abc", "abcbc"));
    }

    @Test
    public void shortestWay_abc_acdbc_m1() {
        Solution solution = new Solution();
        assertEquals(-1, solution.shortestWay("abc", "acdbc"));
    }

    @Test
    public void shortestWay_abc_acbac_3() {
        Solution solution = new Solution();
        assertEquals(3, solution.shortestWay("abc", "acbac"));
    }

    @Test
    public void shortestWay_xyz_xzyxz_3() {
        Solution solution = new Solution();
        assertEquals(3, solution.shortestWay("xyz", "xzyxz"));
    }

//    @Test
//    public void shortestWay_abc_abcbc_2() {
//
//    }
//
//    @Test
//    public void shortestWay_abc_abcbc_2() {
//
//    }
}
