package leetcode.LC_077;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naco_siren on 7/15/17.
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> r1 = combine(4, 2);

        return;
    }

    public static List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<List<Integer>> results = new ArrayList<>();

        recur(n, k, 1, prefix, results);
        return results;
    }

    private static void recur(int n, int k, int index, ArrayList<Integer> prefix, ArrayList<List<Integer>> results) {
        /* Prune if the remaining elements are not enough to fill the vacancy */
        if (n - index + 1 < k)
            return;

        /* Add to results if already k elements */
        if (k == 0) {
            results.add((ArrayList<Integer>) prefix.clone());
            return;
        }

        /* Recursion and back-tracking */
        prefix.add(index);
        recur(n, k - 1, index + 1, prefix, results); // Use current element
        prefix.remove(prefix.size() - 1); // Backtrack to remove it
        recur(n, k, index + 1, prefix, results); // Do not use current element

    }
}
