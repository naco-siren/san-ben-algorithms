package leetcode.LC_051;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution051_2 {

    private final int N;

    Solution051_2(final int n) {
        this.N = n;
    }

    public List<List<String>> solve() {
        LinkedList<ArrayList<Integer>> results = new LinkedList<>();
        dfs(0, new ArrayList<>(), results);
        return output(results);
    }

    private void dfs(final int r, ArrayList<Integer> prefix, LinkedList<ArrayList<Integer>> results) {
        // Mark the slots attacked by Queens in the prefix
        boolean[] attacked = genAttackedSlots(r, prefix);

        // Perform DFS from all non-attacked slots
        for (int j = 0; j < N; j++) {
            if (attacked[j])
                continue;

            if (r == N - 1) {
                // Collect results on final row
                ArrayList<Integer> result = new ArrayList<>(prefix);
                result.add(j);
                results.add(result);

            } else {
                // DFS
                prefix.add(j);
                dfs(r+1, prefix, results);
                prefix.remove(r);
            }
        }
    }

    private boolean[] genAttackedSlots(final int r, ArrayList<Integer> prefix) {
        boolean[] attacked = new boolean[N];
        for (int i = 0; i < r; i++) {
            int c = prefix.get(i);

            attacked[c] = true;
            if (c - (r - i) >= 0) attacked[c - (r - i)] = true;
            if (c + (r - i) < N) attacked[c + (r - i)] = true;
        }
        return attacked;
    }

    private List<List<String>> output(LinkedList<ArrayList<Integer>> inputs) {
        LinkedList<List<String>> outputs = new LinkedList<>();

        for (ArrayList<Integer> input : inputs) {
            List<String> output = new LinkedList<>();

            for (int c : input) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < c; i++)
                    builder.append('.');
                builder.append('Q');
                for (int i = c + 1; i < N; i++)
                    builder.append('.');

                output.add(builder.toString());
            }
            outputs.add(output);
        }
        return outputs;
    }
}
