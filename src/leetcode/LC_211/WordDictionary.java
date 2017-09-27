package leetcode.LC_211;

import java.util.Stack;

/**
 * Created by naco_siren on 9/26/17.
 */
public class WordDictionary {

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;

        for(char ch : word.toCharArray()){
            if(cur.children[ch - 'a'] == null)
                cur.children[ch - 'a'] = new TrieNode();
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));


        while(stack.isEmpty() == false){

            Pair pair = stack.pop();
            TrieNode node = pair.node;
            int depth = pair.depth;

            if(depth == word.length()){
                if(node.isWord == true)
                    return true;
                else
                    continue;
            }


            char c = word.charAt(depth);
            if(c == '.'){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    TrieNode next = node.children[ch-'a'];
                    if(next != null)
                        stack.push(new Pair(next, depth + 1));
                }

            } else {
                TrieNode next = node.children[c-'a'];
                if(next == null)
                    continue;
                else
                    stack.push(new Pair(next, depth + 1));

            }

        }
        return false;
    }


    class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];

        public TrieNode(){
        }
    }

    class Pair{
        TrieNode node;
        int depth;
        public Pair(TrieNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}
