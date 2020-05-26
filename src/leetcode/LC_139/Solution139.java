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
        for (int i = 1; i <= s.length(); i++) {     // `i` is not index of `s`, but index of `isBreak` array instead.
            for (String word : dict) {
                if (word.length() <= i && isBreak[i - word.length()]
                        && s.substring(i - word.length(), i).equals(word)) {
                    isBreak[i] = true;
                    break;
                }
            }
        }
        return isBreak[s.length()];
    }
}
