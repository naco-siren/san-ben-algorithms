package leetcode.LC_140;

import java.util.*;

public class SolutionRecursive {
    public static void main(String[] args) {
        SolutionRecursive s1 = new SolutionRecursive();

        List<String> r0 = s1.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        // (Empty)

        List<String> r1 = s1.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
//        "cats and dog"
//        "cat sand dog"

        List<String> r2 = s1.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        "pine apple pen apple"
//        "pineapple pen apple"
//        "pine applepen apple"
    }

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
        for (String word : words) {
            TrieNode iter = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (iter.children[ch - 'a'] == null)
                    iter.children[ch - 'a'] = new TrieNode(ch);
                iter = iter.children[ch - 'a'];
            }
            iter.isWord = true;
        }
        return root;
    }

    private void dfs(final TrieNode trie, final String s,
                     final LinkedList<String> prefix, final List<List<String>> results) {
        if (s.length() == 0) {
            if (!prefix.isEmpty())
                results.add(new LinkedList<>(prefix));
            return;
        }

        TrieNode iter = trie;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (iter.children[ch - 'a'] == null)
                return;

            iter = iter.children[ch - 'a'];
            if (iter.isWord) {
                prefix.add(s.substring(0, i + 1));
                dfs(trie, s.substring(i + 1), prefix, results);
                prefix.removeLast();
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
