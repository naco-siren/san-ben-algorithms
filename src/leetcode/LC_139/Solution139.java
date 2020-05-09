package leetcode.LC_139;

import java.util.*;

/**
 * 139. Word Break
 */
class Solution139 {
    boolean wordBreak(String s, List<String> wordDict) {
        // Initialize a word set as dict
        Set<String> dict = new TreeSet<>(wordDict);

        // Initialize a boolean array to memorize if s[:i] is breakable
        boolean[] isBreak = new boolean[s.length() + 1];
        isBreak[0] = true;

        // Perform dynamic programming
        for (int i = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (word.length() <= i + 1
                        && isBreak[i - word.length() + 1]
                        && s.substring(i - word.length() + 1, i + 1).equals(word)) {
                    isBreak[i + 1] = true;
                    break;
                }
            }
        }
        return isBreak[s.length()];
    }
}
