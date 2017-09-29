package leetcode.LC_211;

import java.util.Stack;

/**
 * Created by naco_siren on 9/26/17.
 */
public class WordDictionary {

    TrieNode root = new TrieNode();

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode cur = root;

        /* Drill down the tree along each character's leaf */
        for(char ch : word.toCharArray()){
            if (cur.children[ch - 'a'] == null)
                cur.children[ch - 'a'] = new TrieNode();

            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could
     * contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        /* Use a stack to maintain the candidates */
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while(stack.isEmpty() == false){
            /* Pop the next candidate from stack */
            Pair pair = stack.pop();
            TrieNode node = pair.node;
            int depth = pair.depth;

            /* On reaching the last character,
               return true if current node is word,
               or continue to pop next candidate from stack */
            if (depth == word.length()) {
                if(node.isWord == true)
                    return true;
                else
                    continue; // Continue to next candidate in stack
            }

            /* Push all possible candidates into stack */
            char ch = word.charAt(depth);
            if (ch == '.') {
                /* Push all the characters */
                for (char c = 'a'; c <= 'z'; c++) {
                    TrieNode next = node.children[c-'a'];
                    if (next != null)
                        stack.push(new Pair(next, depth + 1));
                }

            } else {
                /* Only push the character specified by pattern */
                TrieNode next = node.children[ch-'a'];
                if (next != null)
                    stack.push(new Pair(next, depth + 1));
            }

        }
        return false;
    }

    class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];  // Assume all the characters are lower cased

        public TrieNode(){
        }
    }

    /**
     * Use "Pair" to keep track of the node and its corresponding index in the pattern
     */
    class Pair{
        TrieNode node;
        int depth;

        public Pair(TrieNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}
