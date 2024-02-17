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

        // BFS starting from the last element
        int minJumps = N;

        Queue<State> queue = new LinkedList<>();
        boolean[] requested = new boolean[N];
        int[] dp = new int[N];
        Arrays.fill(dp, N);

        requested[N - 1] = true;
        queue.offer(new State(N - 1, 0));

        while (!queue.isEmpty()) {
            final State current = queue.poll();

            // Already performing worse than our best result so far
            if (current.jumps >= minJumps)
                continue;
            // Already performing worse than this current position
            if (current.jumps >= dp[current.index])
                continue;

            // Update dp
            dp[current.index] = current.jumps;
            final int value = arr[current.index];

            // IF HIT, update minJumps
            if (current.index == 0) {
                minJumps = current.jumps;
                continue;
            }

            final int nextJumps = current.jumps + 1;

            // Queue next available jump targets
            Set<Integer> equalIndices = valToIdx.get(value);
            if (equalIndices != null) {
                for (Integer idx : equalIndices) {
                    if (requested[idx])
                        continue;

                    // Only enqueue the candidate if it has potential
                    if (dp[idx] > nextJumps) {
                        requested[idx] = true;
                        queue.offer(new State(idx, nextJumps));
                    }
                }
            }

            final int leftIdx = current.index - 1;
            if (leftIdx >= 0 && !requested[leftIdx] && dp[leftIdx] > nextJumps) {
                requested[leftIdx] = true;
                queue.offer(new State(leftIdx, nextJumps));
            }

            final int rightIdx = current.index + 1;
            if (rightIdx < N && !requested[rightIdx] && dp[rightIdx] > nextJumps) {
                requested[rightIdx] = true;
                queue.offer(new State(rightIdx, nextJumps));
            }
        }
        return minJumps;
    }

    private static class State {
        int index;
        int jumps;

        private State(int index, int jumps) {
            this.index = index;
            this.jumps = jumps;
        }
    }
}
