package leetcode.LC_163;

import java.util.*;

/**
 * 163. Missing Ranges
 */
public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<Pair> result = new ArrayList<>();

        if (nums.length == 0) {
            result.add(new Pair(lower - 1, upper + 1));
            return formatPairs(result);
        }

        // {lower, nums[0]}
        result.add(new Pair(lower - 1, nums[0]));

        // {nums[0], nums[n-1]}
        for (int i = 0; i < nums.length - 1; i++) {
            result.add(new Pair(nums[i], nums[i+1]));
        }

        // {nums[n-1], upper}
        result.add(new Pair(nums[nums.length - 1], upper + 1));

        return formatPairs(result);
    }

    List<String> formatPairs(List<Pair> pairs) {
        List<String> formatted = new ArrayList<>();
        for (Pair pair : pairs) {
            String val = pair.toString();
            if (val != null)
                formatted.add(val);
        }
        return formatted;
    }

    static class Pair {
        final int first;
        final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            if (second <= first) {
                throw new IllegalArgumentException("second value is supposed to be larger than first!");
            } else if (second == first + 1) {
                return null;
            } else if (second == first + 2) {
                return String.valueOf(first + 1);
            } else {
                return String.valueOf(first + 1) + "->" + String.valueOf(second - 1);
            }
        }
    }
}
