package leetcode.LC_126;


import java.util.*;

/**
 * 126. Word Ladder II
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);

        HashMap<String, Integer> used = new HashMap<>();
        used.put(beginWord, 0);

        LinkedList<Candidate> bfsQ = new LinkedList<>();
        bfsQ.offer(new Candidate(beginWord, 1, null));

        LinkedList<List<String>> ladders = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;

        while (!bfsQ.isEmpty()) {
            // Check if endWord reached
            Candidate cur = bfsQ.poll();
            if (cur.word.equals(endWord)) {
                if (cur.dist < minLen) {
                    minLen = cur.dist;
                    ladders.clear();
                    ladders.offer(generatePath(cur));
                } else if (cur.dist == minLen) {
                    ladders.offer(generatePath(cur));
                }
                continue;
            }

            // Perform BFS
            List<Candidate> nextWords = bfs(cur, dict);
            for (Candidate nextWord : nextWords) {
                if (used.containsKey(nextWord.word) && used.get(nextWord.word) < nextWord.dist)
                    continue;

                // Add to Queue and mark as used
                bfsQ.offer(nextWord);
                used.put(nextWord.word, nextWord.dist);
            }
        }
        return ladders;
    }

    private List<Candidate> bfs(final Candidate curWord, final HashSet<String> dict) {
        LinkedList<Candidate> result = new LinkedList<>();
        StringBuilder builder = new StringBuilder(curWord.word);
        for (int i = 0; i < curWord.word.length(); i++) {
            char ch = curWord.word.charAt(i);
            for (int j = 0; j < 26; j++) {
                // Skip current char
                if ('a' + j == ch)
                    continue;

                // Enumerate possible candidate
                builder.setCharAt(i, (char) ('a' + j));
                final String cand = builder.toString();
                if (dict.contains(cand))
                    result.add(new Candidate(cand, curWord.dist + 1, curWord));
            }
            // Backtrack
            builder.setCharAt(i, ch);
        }
        return result;
    }

    List<String> generatePath(Candidate tail) {
        LinkedList<String> path = new LinkedList<>();
        while (tail != null) {
            path.addFirst(tail.word);
            tail = tail.parent;
        }
        return path;
    }

    class Candidate {
        String word;
        int dist;
        Candidate parent;

        public Candidate(String word, int dist, Candidate parent) {
            this.word = word;
            this.dist = dist;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return word + ", " + dist;
        }
    }
}
