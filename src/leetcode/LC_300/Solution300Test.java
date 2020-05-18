package leetcode.LC_300;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution300Test {

    @Test
    public void lengthOfLIS_1() {
        assertEquals(3, new Solution300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));

        // DP:
        // 0    10
        // 1    9
        // 2    2
        // 3    2, 5
        // 4    2, 3
        // 5    2, 3, 4
    }

    @Test
    public void lengthOfLIS_2() {
        assertEquals(4, new Solution300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

        // DP:
        // 0    10
        // 1    9
        // 2    2
        // 3    2, 5
        // 4    2, 3
        // 5    2, 3, 7
        // 6    2, 3, 7, 101
        // 7    2, 3, 7, 18
    }

    @Test
    public void lengthOfLIS_3() {
        assertEquals(3, new Solution300().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));

        // DP:
        // 0    4
        // 1    4, 10
        // 2    4, 10   (update dp[0] with 4, dp remains the same, so does `maxIdx`)
        // 3    3, 10   (even if we update dp[0], `maxIdx` is still `1`)
        // 4    3, 8    (even if we update dp[1], `maxIdx` is still `1`)
        // 5    3, 8, 9 (finally update `maxIdx` to `2`)
    }

    @Test
    public void lengthOfLIS_4() {
        assertEquals(6, new Solution300().lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));

        // DP:
        // 0    3
        // 1    3, 5
        // 2    3, 5, 6
        // 3    2, 5, 6
        // 4    2, 5, 6
        // 5    2, 4, 6     (If `l < r`, here it'd become `4, 5, 6`)
        // 6    2, 4, 6, 19
        // 7    2, 4, 5, 19
        // 8    2, 4, 5, 6
        // 9    2, 4, 5, 6, 7
        // 9    2, 4, 5, 6, 7, 12
    }
}