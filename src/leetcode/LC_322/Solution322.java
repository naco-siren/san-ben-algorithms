package leetcode.LC_322;

import java.util.*;

/**
 * 322. Coin Change
 */
class Solution322 {
    int coinChange(int[] coins, int amount) {
        // Sort coins in ascending order
        Arrays.sort(coins);

        // Initialize an array to memorize the min changes starting from amount of 0.
        int[] minChanges = new int[amount + 1];
        Arrays.fill(minChanges, Integer.MAX_VALUE);
        minChanges[0] = 0;

        // Perform dynamic programming on
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    break;

                if (minChanges[i - coin] != Integer.MAX_VALUE)
                    minChanges[i] = Math.min(minChanges[i], minChanges[i - coin] + 1);
            }
        }
        return minChanges[amount] == Integer.MAX_VALUE ? -1 : minChanges[amount];
    }

    int coinChange2(int[] coins, int amount) {
        // Sort coins in ascending order and initialize a TreeMap index.
        Arrays.sort(coins);
        TreeMap<Integer, Integer> indices = new TreeMap<>();
        for (int i = 0; i < coins.length; i++)
            if (!indices.containsKey(coins[i]))
                indices.put(coins[i], i);

        // Initialize an array to memorize the min changes starting from amount of 0.
        int[] minChanges = new int[amount + 1];
        Arrays.fill(minChanges, Integer.MAX_VALUE);
        minChanges[0] = 0;

        // Perform dynamic programming on
        for (int i = 1; i <= amount; i++) {
            // The maximum coin to fill the gap
            final Map.Entry<Integer, Integer> maxCoin = indices.floorEntry(i);
            if (maxCoin == null)
                continue;

            for (int j = 0; j <= maxCoin.getValue(); j++) {
                int existingAmount = i - coins[j];
                if (minChanges[existingAmount] != Integer.MAX_VALUE) {
                    minChanges[i] = Math.min(minChanges[i], minChanges[existingAmount] + 1);
                }
            }
        }
        return minChanges[amount] == Integer.MAX_VALUE ? -1 : minChanges[amount];
    }
}
