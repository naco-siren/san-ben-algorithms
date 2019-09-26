package leetcode.LC_212;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 */
public class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        // Setup
        final int R = board.length, C = board[0].length;
        final TrieNode root = constructTrie(words);
        final Set<String> results = new HashSet<>();

        // A flag matrix to indicate if a character has been used in a certain DFS
        final boolean[][] used = new boolean[R][];
        for (int r = 0; r < R; r++)
            used[r] = new boolean[C];

        // Perform DFS through recursion
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                helper(board, used, r, c, root, builder, results);
            }
        }
        return new LinkedList<>(results);
    }

    void helper(final char[][] board, final boolean[][] used, final int r, final int c, TrieNode parent,
                StringBuilder builder, Set<String> results) {
        // Check if already in use
        if (used[r][c])
            return;
        used[r][c] = true;

        // Check if current character exist in Trie as prefix
        final char ch = board[r][c];
        TrieNode cur = parent.children[ch - 'a'];
        if (cur != null) {
            builder.append(ch);

            if (cur.isWord)
                results.add(builder.toString());

            if (r < board.length - 1)
                helper(board, used, r + 1, c, cur, builder, results);
            if (c < board[0].length - 1)
                helper(board, used, r, c + 1, cur, builder, results);
            if (r > 0)
                helper(board, used, r - 1, c, cur, builder, results);
            if (c > 0)
                helper(board, used, r, c - 1, cur, builder, results);

            builder.setLength(builder.length() - 1);
        }
        used[r][c] = false;
    }

    TrieNode constructTrie(final String[] words) {
        TrieNode root = new TrieNode();
        root.isWord = false;
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int chIdx = word.charAt(i) - 'a';
                if (cur.children[chIdx] == null) {
                    cur.children[chIdx] = new TrieNode();
                    cur.children[chIdx].ch = word.charAt(i);
                    cur.children[chIdx].parent = cur;
                }
                cur = cur.children[chIdx];
            }
            cur.isWord = true;
        }
        return root;
    }

    boolean trieContains(final TrieNode root, String word) {
        return findPrefixTrieNode(root, word).isWord;
    }

    TrieNode findPrefixTrieNode(final TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int chIdx = word.charAt(i) - 'a';
            if (cur.children[chIdx] == null) {
                return null;
            } else {
                cur = cur.children[chIdx];
            }
        }
        return cur;
    }

    class TrieNode {
        boolean isWord = false;
        char ch;
        TrieNode[] children = new TrieNode[26];  // Assume all the characters are lower cased
        TrieNode parent;
        TrieNode() {}
    }
}
