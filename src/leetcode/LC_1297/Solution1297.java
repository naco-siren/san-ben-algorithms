package leetcode.LC_1297;

import java.util.*;

/**
 * 1297. Maximum Number of Occurrences of a Substring
 */
public class Solution1297 {
    public int maxFreq(final String s, final int maxLetters, final int minSize, final int maxSize) {
        Map<String, Integer> maxFrequencies = new HashMap<>();

        Map<Character, Integer> substringHistogram = new HashMap<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            // Expand ending edge until minSize reached
            while (end < s.length() && (end - start + 1) <= minSize) {      // KEY HERE IS TO UNDERSTAND THAT `maxSize` is useless, because shorter substrings ALWAYS has equal or more occurances
                final char endChar = s.charAt(end);
                substringHistogram.put(endChar, substringHistogram.getOrDefault(endChar, 0) + 1);
                end++;
            }

            // Update record if not exceed maxLetters
            if (end <= s.length() && substringHistogram.size() <= maxLetters) {
                final String substring = s.substring(start, end);
                maxFrequencies.put(substring, maxFrequencies.getOrDefault(substring, 0) + 1);
            }

            // Remove the key when start char leaves window,
            // because an entry of `{startCh -> 0}` will affect the `histogram.size()` condition check
            final char startChar = s.charAt(start);
            substringHistogram.put(startChar, substringHistogram.get(startChar) - 1);
            if (substringHistogram.get(startChar) == 0)
                substringHistogram.remove(startChar);

            // SHRINK STARTING EDGE BY **ONLY ONE**
            start++;
        }

        Optional<Map.Entry<String, Integer>> maxFreqOpt = maxFrequencies.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));
        return maxFreqOpt.isPresent() ? maxFreqOpt.get().getValue() : 0;
    }
}
