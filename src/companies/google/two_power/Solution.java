package companies.google.two_power;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> r1 = solve(5);
        List<List<Integer>> r2 = solve(7);

        return;
    }


    public static List<List<Integer>> solve(int N) {

        HashMap<Integer, List<List<Integer>>> map = new HashMap<>(N + 1);

        /* Initialize 0 */
        List<List<Integer>> prefix = new LinkedList<>();
        prefix.add(new LinkedList<>());
        map.put(0, prefix);

        /* Perform DP */
        for (int i = 0; i <= N; i++) {
            List<List<Integer>> srcPrefixes = map.getOrDefault(i, new LinkedList<>());
            for (List<Integer> p : srcPrefixes)
                p.add(i);
            map.put(i, srcPrefixes);

            /* Stop on N */
            if (i == N) break;

            /* Render all [i + 2^k] indexes */
            int folds = 1;
            while (i + folds <= N) {
                int j = i + folds;

                List<List<Integer>> targetPrefixes = map.getOrDefault(j, new LinkedList<>());
                for (List<Integer> p : srcPrefixes)
                    targetPrefixes.add(new LinkedList<>(p));
                map.put(j, targetPrefixes);

                folds += folds;
            }
        }

        return map.get(N);
    }

}
