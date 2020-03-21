package leetcode.LC_846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 846. Hand of Straights
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        // Total N cards in the array, each group has a size of W, altogether GROUP groups
        int TOTAL = hand.length, GROUPS = TOTAL / W;
        if (TOTAL % W != 0)
            return false;
        if (W == 1)
            return true;

        Arrays.sort(hand);

        // Initialize a histogram
        Map<Integer, Integer> histogram = new HashMap<>();
        for (int i = 0; i < TOTAL; i++) {
            final int card = hand[i];
            Integer count = histogram.get(card);
            histogram.put(card, count == null ? 1: count + 1);
        }

        // Go through the sorted cards to gather each group
        for (int i = 0; i < TOTAL; i++) {
            final int card = hand[i];
            if (histogram.get(card) <= 0)
                continue;

            for (int j = 0; j < W; j++) {
                final int next = card + j;
                final Integer count = histogram.get(next);
                if (count == null || count <= 0)
                    return false;
                histogram.put(next, count - 1);
            }
        }
        return true;
    }
}