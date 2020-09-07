package leetcode.LC_140;

import java.util.*;

/**
 * 140. Word Break II
 */
public class Solution140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Generate a HashSet of words
        final TrieNode trie = generateTrie(wordDict);

        // DFS
        List<List<String>> results = new LinkedList<>();
        dfs(trie, s, new LinkedList<>(), results);

        // Format the results for output
        List<String> output = new LinkedList<>();
        for (List<String> result : results) {
            StringBuilder builder = new StringBuilder(result.get(0));
            for (int i = 1; i < result.size(); i++) {
                builder.append(" ");
                builder.append(result.get(i));
            }
            output.add(builder.toString());
        }
        return output;
    }

    private TrieNode generateTrie(List<String> words) {
        TrieNode root = new TrieNode((char) 0);
        for (String word : words)
            addWordToTrie(root, word);
        return root;
    }

    private void addWordToTrie(TrieNode trieRoot, String word) {
        TrieNode iter = trieRoot;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (iter.children[ch - 'a'] == null)
                iter.children[ch - 'a'] = new TrieNode(ch);
            iter = iter.children[ch - 'a'];
        }
        iter.isWord = true;
    }

    private void dfs(
            final TrieNode trieRoot,
            final String s,             // PAY ATTENTION TO THE USE OF STRING INSTEAD OF STRINGBUILDER...
            final LinkedList<String> prefix,    // current result candidate's word prefix
            final List<List<String>> results) {

        // Reaches the end of string
        if (s.length() == 0) {
            if (!prefix.isEmpty())
                results.add(new LinkedList<>(prefix));  // the only place to update results
            return;
        }

        TrieNode iter = trieRoot;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (iter.children[ch - 'a'] == null)
                return;

            iter = iter.children[ch - 'a'];
            if (iter.isWord) {
                prefix.add(s.substring(0, i + 1));  // Add current candidate into prefix,

                dfs(trieRoot, s.substring(i + 1), prefix, results);     //... WHICH ALLOWS FOR SUBSTRING

                prefix.removeLast();                // backtrack, remove current candidate
            }
        }
    }

    private static class TrieNode {
        char value;
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];  // Assume all the characters are lower cased

        TrieNode(char ch) {
            value = ch;
        }
    }
}
