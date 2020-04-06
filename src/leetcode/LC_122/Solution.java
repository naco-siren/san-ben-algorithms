package leetcode.LC_122;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }
}
