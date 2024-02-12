package leetcode.LC_3035;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution3035Test {
    @Test
    public void maxPalindromesAfterOperations_1() {
        assertEquals(3, new Solution3035().maxPalindromesAfterOperations(new String[]{"abbb","ba","aa"}));
    }

    @Test
    public void maxPalindromesAfterOperations_2() {
        assertEquals(2, new Solution3035().maxPalindromesAfterOperations(new String[]{"abc","ab"}));
    }

    @Test
    public void maxPalindromesAfterOperations_3() {
        assertEquals(1, new Solution3035().maxPalindromesAfterOperations(new String[]{"cd","ef","a"}));
    }

    @Test
    public void maxPalindromesAfterOperations_4() {
        assertEquals(2, new Solution3035().maxPalindromesAfterOperations(new String[]{"a","b"}));
    }

    @Test
    public void maxPalindromesAfterOperations_5() {
        assertEquals(1, new Solution3035().maxPalindromesAfterOperations(new String[]{"ggcbd","baae"}));
    }

    @Test
    public void maxPalindromesAfterOperations_6() {
        assertEquals(3, new Solution3035().maxPalindromesAfterOperations(new String[]{"a","a","caa"}));
    }


    @Test
    public void maxPalindromesAfterOperations_7() {
        assertEquals(2, new Solution3035().maxPalindromesAfterOperations(new String[]{"aab","ac","bb"}));
    }
}
