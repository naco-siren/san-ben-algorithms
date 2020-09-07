package leetcode.LC_140;

import java.util.*;

/**
 * 140. Word Break II
 */
public class Solution140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Early return on validation failure
        if (!validate(s, wordDict))
            return new LinkedList<>();

        // Generate a HashSet of words
        final TrieNode trie = generateTrie(wordDict);

        // Perform DFS
        List<List<String>> results = new LinkedList<>();
        dfs(trie, s, new LinkedList<>(), results);

        // Format the results for output
        List<String> output = new LinkedList<>();
        for (List<String> result : results)
            output.add(String.join(" ", result));
        return output;
    }

    private boolean validate(String s, List<String> wordDict) {
        int[] charsNeeded = new int[26];
        Arrays.fill(charsNeeded, -1);

        for (char ch : s.toCharArray())
            charsNeeded[ch - 'a'] = 1;

        for (String word : wordDict) {
            for (char ch : word.toCharArray())
                charsNeeded[ch - 'a'] = 0;
        }

        for (int charNeeded : charsNeeded) {
            if (charNeeded == 1)
                return false;
        }
        return true;
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
            TrieNode child = iter.children[ch - 'a'];
            if (child == null)
                return;

            if (child.isWord) {
                prefix.add(s.substring(0, i + 1));  // Add current candidate into prefix,

                dfs(trieRoot, s.substring(i + 1), prefix, results);     //... WHICH ALLOWS FOR SUBSTRING

                prefix.removeLast();                // backtrack, remove current candidate
            }

            iter = child;
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
