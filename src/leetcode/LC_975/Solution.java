package leetcode.LC_975;

import java.util.Map;
import java.util.TreeMap;

/**
 * 975. Odd Even Jump
 */
public class Solution {
    public int oddEvenJumps(int[] A) {
        // Corner case
        final int N = A.length;
        if (A.length < 2)
            return A.length;

        // DP
        boolean[] odds = new boolean[N];
        boolean[] evens = new boolean[N];

        // Reverse traversal
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[N-1], N-1);
        odds[N-1] = true;   evens[N-1] = true;
        for (int i = N - 2; i >= 0; i--) {
            // Update odds
            Map.Entry<Integer, Integer> odd = map.ceilingEntry(A[i]);
            if (odd != null) {
                odds[i] = evens[odd.getValue()];
            }

            // Update evens
            Map.Entry<Integer, Integer> even = map.floorEntry(A[i]);
            if (even != null) {
                evens[i] = odds[even.getValue()];
            }

            // Update TreeMap
            map.put(A[i], i);
        }

        // Collect result
        int counter = 0;
        for (int i = 0; i < N; i++)
            if (odds[i])
                counter++;
        return counter;
    }
}
