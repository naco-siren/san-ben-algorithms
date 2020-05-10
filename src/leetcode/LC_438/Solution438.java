package leetcode.LC_438;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 */
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();

        // Handle corner case
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen)
            return output;

        // Build reference array using string `p`
        int [] pCount = new int[26];
        for (char ch : p.toCharArray())
            pCount[ch - 'a']++;

        // Sliding window on the string `s`
        int [] sCount = new int[26];
        for (int i = 0; i < sLen; i++) {
            // Add one more letter on the right side of the window
            sCount[s.charAt(i) - 'a']++;

            // Remove one letter from the left side of the window
            if (i >= pLen)
                sCount[s.charAt(i - pLen) - 'a']--;

            // Compare array in the sliding window with the reference array
            if (Arrays.equals(pCount, sCount))
                output.add(i - pLen + 1);
        }
        return output;
    }
}
