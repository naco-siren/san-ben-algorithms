package companies.google.longest_consecutive_sublist;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] r1 = solve(new int[]{1, 4, 2, 3, 5, 6, 7, 6, 7, 8, 9}); // [6, 7, 8, 9]
        int[] r2 = solve(new int[]{1, 4, 2, 3, 5, 6, 7, 6, 7}); // [5, 6, 7]

        return;
    }

    public static int[] solve(int[] arr) {
        int len = arr.length;

        // Pruning
        if (len == 1) return arr;

        // Start with the second number in the array
        int prev = arr[0], curLen = 1, maxLen = 1, maxStart = 0;
        for (int i = 1; i < len; i++) {
            // Update length of the current consecutive list
            if (arr[i] == prev + 1) {
                curLen++;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    maxStart = i - curLen + 1;
                }

            } else {
                curLen = 1;
            }

            prev = arr[i];
        }

        return Arrays.copyOfRange(arr, maxStart, maxStart + maxLen);
    }
}
