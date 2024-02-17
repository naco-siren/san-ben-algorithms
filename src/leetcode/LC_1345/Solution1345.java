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
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(N - 1, 0));

        int minJumps = N;

        int[] dp = new int[N];
        Arrays.fill(dp, N);

        while (!queue.isEmpty()) {
            final State current = queue.poll();
            final int value = arr[current.index];

            // Already performing worse than what we have right now
            if (current.jumps >= minJumps)
                continue;

            // Update dp and minJumps if hit
            if (current.jumps < dp[current.index]) {
                dp[current.index] = current.jumps;

                if (current.index == 0) {
                    minJumps = Math.min(minJumps, current.jumps);
                    continue;
                }
            } else {
                continue;
            }

            // Queue next available jump targets
            if (current.index - 1 >= 0) {
                queue.offer(new State(current.index - 1, current.jumps + 1));
            }
            if (current.index + 1 < N) {
                queue.offer(new State(current.index + 1, current.jumps + 1));
            }

            Set<Integer> equalIndices = valToIdx.get(value);
            if (equalIndices != null) {
                for (Integer idx : equalIndices) {
                    queue.offer(new State(idx, current.jumps + 1));
                }
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
