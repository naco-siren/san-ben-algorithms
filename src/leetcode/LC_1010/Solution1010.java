package leetcode.LC_1010;

import java.util.*;

public class Solution1010 {
    public int numPairsDivisibleBy60(int[] times) {
        Map<Integer, Integer> remaindersFreqs = new HashMap<>();

        for (int time : times) {
            final int remainder = time % 60;
            remaindersFreqs.put(remainder, remaindersFreqs.getOrDefault(remainder, 0) + 1);
        }

        long pairsCount = 0;
        for (Map.Entry<Integer, Integer> entry : remaindersFreqs.entrySet()) {
            final int remainder = entry.getKey();
            final long freq = (long) entry.getValue();

            if (remainder == 0 || remainder == 30) {
                pairsCount += freq * (freq - 1) / 2;
            } else if (remainder < 30) {
                final int pairFreq = remaindersFreqs.getOrDefault(60 - remainder, 0);
                pairsCount += freq * pairFreq;
            } else {
                // noop
            }
        }

        return (int) pairsCount;
    }
}
