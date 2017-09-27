package leetcode;
import java.util.HashMap;

/**
 * Created by naco_siren on 9/26/17.
 */
public class LC_128 {
    public static void main(String[] args) {
        int r1 = longestConsecutiveSequence(new int[]{0,3,7,2,5,8,4,6,0,1}); // [9]
        int r2 = longestConsecutiveSequence(new int[]{0,2,5,8,4,6,1}); // [3] : 4, 5, 6

        return;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        /* Hashing number to the length of the longest sequence it belongs to */
        HashMap<Integer, Integer> neighbors = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            /* Process each number only once */
            if (neighbors.containsKey(num))
                continue;

            Integer left = neighbors.get(num - 1);
            Integer right = neighbors.get(num + 1);

            int l = left != null ? left : 0;
            int r = right != null ? right : 0;

            /* Calculate current sequence's length */
            int len = l + 1 + r;
            if(len > maxLen)
                maxLen = len;
            neighbors.put(num, len);

            /* Update the left and right edges of the sequence */
            if (left != null)
                neighbors.put(num - l, len);
            if (right != null)
                neighbors.put(num + r, len);
        }

        return maxLen;
    }

}
