package leetcode.LC_128;
import java.util.HashMap;

/**
 * 128. Longest Consecutive Sequence
 */
public class Solution128 {
    int longestConsecutiveSequence(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        /* Hashing number to the length of the longest sequence it belongs to */
        HashMap<Integer, Integer> neighbors = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            /* Process each number only once */
            if (neighbors.containsKey(num))
                continue;

            final int left = neighbors.getOrDefault(num - 1, 0);
            final int right = neighbors.getOrDefault(num + 1, 0);

            /* Calculate current sequence's length */
            final int len = left + 1 + right;
            maxLen = Math.max(maxLen, len);
            neighbors.put(num, len);

            /* Update the left and right edges of the sequence */
            if (left != 0)
                neighbors.put(num - left, len);
            if (right != 0)
                neighbors.put(num + right, len);
        }

        return maxLen;
    }
}
