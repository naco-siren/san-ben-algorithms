package leetcode.LC_666;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution666Test {

    @Test
    public void sample_0() {
         assertEquals(12, new Solution666().pathSum(new int[]{113,215,221}));
    }

    @Test
    public void sample_1() {
         assertEquals(4, new Solution666().pathSum(new int[]{113,221}));
    }

    @Test
    public void my_case_0() {
         assertEquals(20, new Solution666().pathSum(new int[]{115,217,222,331}));
    }
}
