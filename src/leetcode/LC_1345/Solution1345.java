package leetcode.LC_1345;

import java.util.*;

/**
 * 1345. Jump Game IV
 */
public class Solution1345 {
    public int minJumps(int[] arr) {
        final int N = arr.length;

        // Construct a value to index mapping
        Map<Integer, Set<Integer>> valToIdx = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Set<Integer> indices = valToIdx.getOrDefault(arr[i], new HashSet<>());
            indices.add(i);
            valToIdx.put(arr[i], indices);
        }


        // BFS starting from the first element
        Queue<Integer> queue = new LinkedList<>();
        boolean[] requested = new boolean[N];

        int jumps = 0;
        requested[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            /*
             * FOR BFS, DO NOT FORGET THAT QUEUE'S SIZE IS CHANGING AS YOU OFFER ITEMS FOR NEXT DEPTH!!!
             */
            for (int i = queue.size(); i > 0; i--) {
                final int idx = queue.poll(), val = arr[idx];

                // IF HIT, update minJumps
                if (idx == N - 1)
                    return jumps;

                // Queue next available jump targets
                Set<Integer> equalIndices = valToIdx.get(val);
                if (equalIndices != null) {
                    for (Integer cand : equalIndices) {
                        if (requested[cand])
                            continue;

                        // Only enqueue the candidate if it has potential
                        requested[cand] = true;
                        queue.offer(cand);
                    }

                    // Dispose the candidate for current value since they are all offered to this queue
                    valToIdx.remove(val);
                }

                if (idx - 1 >= 0 && !requested[idx - 1]) {
                    requested[idx - 1] = true;
                    queue.offer(idx - 1);
                }

                if (idx + 1 < N && !requested[idx + 1]) {
                    requested[idx + 1] = true;
                    queue.offer(idx + 1);
                }
            }
            jumps++;
        }
        return jumps;
    }
}
