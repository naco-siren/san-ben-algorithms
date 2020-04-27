package leetcode.LC_121;

/**
 * 121. Best Time to Buy and Sell Stock
 */
class Solution121 {
    int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Guard corner cases
        if (prices == null || prices.length < 2)
            return maxProfit;

        // Memorize the lowest price so far while iterating through all the prices
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
