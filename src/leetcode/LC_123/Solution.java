package leetcode.LC_123;

/**
 * 123. Best Time to Buy and Sell Stock III
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        // First order
        int[] lefts = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            lefts[i] = Math.max(lefts[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        // Second order
        int[] rights = new int[prices.length];
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            rights[i] = Math.max(rights[i+1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        // Combine to get max(first + second)
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, lefts[i] + rights[i]);
        }
        return result;
    }
}
