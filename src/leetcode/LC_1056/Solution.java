package leetcode.LC_1056;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 1056. Confusing Number
 *
 * Given a number N, return true if and only if it is a confusing number, which satisfies the following condition:
 *
 * We can rotate digits by 180 degrees to form new digits.
 *      When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively.
 *      When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 *
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
 */
public class Solution {
    public static void main(String[] args) {
        // 120
        // 1  2  0
        // 21
    }

    public boolean confusingNumber(final int N) {
        // Init a dict for confusing digits
        final int[] CONFUSING = new int[10];
        Arrays.fill(CONFUSING, -1);
        CONFUSING[0] = 0;
        CONFUSING[1] = 1;
        CONFUSING[6] = 9;
        CONFUSING[8] = 8;
        CONFUSING[9] = 6;

        // Break down input number's decimal value into digits
        int original = N;
        LinkedList<Integer> queue = new LinkedList<>();
        while (original > 0) {
            // Early return if non confusing digit exist
            int digit = original % 10;
            if (CONFUSING[digit] == -1)
                return false;

            // Offer digit to the queue
            queue.offerFirst(CONFUSING[digit]);
            original /= 10;
        }

        // Construct the reversed number's decimal value
        int reversed = 0;
        while (!queue.isEmpty()) {
            int digit = queue.pollLast();
            reversed *= 10;
            reversed += digit;
        }
        return reversed != N;
    }
}
