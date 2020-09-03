package leetcode.LC_621;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 */
public class Solution621 {
    /*
     * Remember that starting from the char with max freq, we arrange it in a structure like this:
     *
     * A _ _ . A _ _ . A _ _ . A         (for A * 4 and n = 2, each _ _ _ represents a group of empty slots)
     *
     * But even if there are multiple chars with max freq >= n, e.g. A * 4, B * 4, C * 3, D * 3
     * it doesn't mean we have to exactly fill n chars into each empty slot group above,
     * i.e. A B C . A B D . A C D . A B C B D
     *
     * Instead, we could simply append more chars into each empty group, IN ORDER:
     * A B C D . A B C D . A B C D . A B
     *
     * This is because the _ _ _ above only presents the MINIMUM slots we must leave,
     * in order to satisfy the cooldown requirement for char with max freq.
     * Meanwhile, by appending other chars into the MINIMUM slots, the cooldown is even better achieved.
     *
     * Since we can arbitrarily append remaining chars IN ORDER into each empty slot group above,
     * AS LONG AS their freq do not exceed max freq (otherwise the structure will be changed).
     *
     * e.g. for the example above, even if we have another E * 4, F * 3 and G * 2
     * starter:     A B C D . A B C D . A B C D . A B
     * insert E:    A B C D E . A B C D E . A B C D E . A B E
     * insert F:    A B C D E F . A B C D E F . A B C D E F . A B E
     * insert G:    A B C D E F G . A B C D E F G . A B C D E F . A B E
     *
     * see? the MINIMUM empty slots are still used up.
     *
     * Therefore, THE ONLY THING WE CARE ABOUT is whether there is still empty slots (i.e. if the empty slots are all taken).
     * this finally arrives at our conclusion:
     *      result = task count + empty slot count
     *
     */
    public int leastInterval(char[] tasks, int n) {
        // Construct Tasks' frequency histogram
        int[] freq = new int[26];
        for (char task : tasks)
            freq[task - 'A']++;
        Arrays.sort(freq);

        // Greedy filling
        int maxFreq = freq[25];
        int emptySlots = (maxFreq - 1) * n;
        for (int i = 24; i >= 0 && emptySlots > 0; i--) {
            emptySlots -= Math.min(maxFreq - 1, freq[i]);
        }

        // Decide if "empty slots are all filled", which is <i>THE ONLY THING WE CARE ABOUT</i>.
        emptySlots = Math.max(0, emptySlots);

        return tasks.length + emptySlots;
    }
}
