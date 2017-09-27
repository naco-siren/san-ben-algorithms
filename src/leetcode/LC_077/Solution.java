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

    private static void recur(int n, int k, int start, ArrayList<Integer> prefix, ArrayList<List<Integer>> results) {
        if (n - start + 1 < k)
            return;

        if (k == 0) {
            results.add((ArrayList<Integer>) prefix.clone());
            return;
        }

        prefix.add(start);
        recur(n, k-1, start+1, prefix, results);
        prefix.remove(prefix.size() - 1);
        recur(n, k, start+1, prefix, results);

    }
}
