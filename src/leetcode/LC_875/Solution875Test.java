package leetcode.LC_875;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 1            <=   piles.length <= 10^4
 * piles.length <=       H        <= 10^9
 * 1            <=    piles[i]    <=  10^9
 */
public class Solution875Test {

    @Test
    public void minEatingSpeed_1() {
        assertEquals(4, new Solution875().minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    @Test
    public void minEatingSpeed_2() {
        assertEquals(30, new Solution875().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }

    @Test
    public void minEatingSpeed_3() {
        assertEquals(23, new Solution875().minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }

    @Test
    public void minEatingSpeed_lower_bound_1() {
        assertEquals(1, new Solution875().minEatingSpeed(new int[]{312884470}, 968709470));
    }

    /**
     * Watch out for `hi` boundary!
     */
    @Test
    public void minEatingSpeed_multiplication_overflow() {
        assertEquals(14, new Solution875().minEatingSpeed(
                new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184},
                823855818));
    }
}