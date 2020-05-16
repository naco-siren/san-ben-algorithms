package leetcode.LC_127;


import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);

        HashSet<String> used = new HashSet<>();
        Queue<Pair<String, Integer>> bfsQ = new LinkedList<>();

        used.add(beginWord);
        bfsQ.offer(Pair.of(beginWord, 1));

        while (!bfsQ.isEmpty()) {
            // Check if endWord reached
            Pair<String, Integer> cur = bfsQ.poll();
            if (cur.getKey().equals(endWord)) {
                return cur.getValue();
            }

            // Perform BFS
            List<String> candidates = enumerateCandidates(cur.getKey(), dict);
            for (String candidate : candidates) {
                if (used.contains(candidate))
                    continue;

                // Add to Queue and mark as used
                used.add(candidate);
                bfsQ.offer(Pair.of(candidate, cur.getValue() + 1));
            }
        }
        return 0;
    }

    private List<String> enumerateCandidates(final String curWord, final HashSet<String> dict) {
        LinkedList<String> candidates = new LinkedList<>();

        StringBuilder builder = new StringBuilder(curWord);
        for (int i = 0; i < curWord.length(); i++) {
            char ch = curWord.charAt(i);
            for (int j = 0; j < 26; j++) {
                // Skip the same char
                if ('a' + j == ch)
                    continue;

                // Enumerate possible candidate
                builder.setCharAt(i, (char) ('a' + j));
                final String cand = builder.toString();
                if (dict.contains(cand))
                    candidates.add(cand);
            }
            // Backtrack
            builder.setCharAt(i, ch);
        }
        return candidates;
    }
}
