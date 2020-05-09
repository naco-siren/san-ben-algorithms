package leetcode.LC_238;

import org.junit.Test;

import static org.junit.Assert.*;

public class Leetcode238Test {

    @Test
    public void productExceptSelf_2_3() {
        assertArrayEquals(new int[]{3, 2}, new Leetcode238().productExceptSelf(new int[]{2, 3}));
    }

    @Test
    public void productExceptSelf_1_2_3_4() {
        assertArrayEquals(new int[]{24,12,8,6}, new Leetcode238().productExceptSelf(new int[]{1,2,3,4}));
    }
}