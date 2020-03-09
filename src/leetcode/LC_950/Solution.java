package leetcode.LC_950;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 950. Reveal Cards In Increasing Order
 */
public class Solution {

    // TODO: Not a good solution

    public static void main(String[] args) {
        // Input: [17,13,11,2,3,5,7]
        // Output: [2,13,3,11,5,17,7]

        // Input: [1,2]
        // Output: [1,2]

        // Input: [1,2,3]
        // Output: [1,3,2]

        // Input: [1,2,3,4]
        // Output: [1,3,2,4]

        // Input: [1,2,3,4,5]
        // Output: [1,5,2,4,3]

        // Input: [1,2,3,4,5,6]
        // Output: [1,4,2,6,3,5]

        // Input: [1,2,3,4,5,6,7]
        // Output: [1,6,2,5,3,7,4]

        // [1,6,2,5,3,7,4]
        // [2,5,3,7,4,6]
        // [3,7,4,6,5]
        // [4,6,5,7]
        // [5,7,6]
        // [6,7]
        // [7]

        // [1,6,2,5,3,7,4]
        // [1,4,2,6,3,5]
        // [1,5,2,4,3]
        // [1,3,2,4]
        // [1,3,2]
        // [1,2]
        // [1]

        // [7,2,6,3,5,1,4]
        // [6,3,5,1,4,2]
        // [5,1,4,2,3]
        // [4,2,3,1]
        // [3,1,2]
        // [2,1]
        // [1]
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        final int LENGTH = deck.length;

        Arrays.sort(deck);

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = LENGTH - 1; i >= 0; i--) {
            if (queue.size() >= 2)
                queue.addFirst(queue.removeLast());
            queue.addFirst(deck[i]);
        }

        final int[] output = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++)
            output[i] = queue.get(i);
        return output;
    }
}
