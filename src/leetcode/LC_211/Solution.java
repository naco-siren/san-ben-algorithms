package leetcode.LC_211;
import java.util.Stack;

/**
 * Created by naco_siren on 9/26/17.
 */
public class Solution {

    public static void main(String[] args) {
        // Your WordDictionary object will be instantiated and called as such:
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("word");
        wordDictionary.addWord("foo");
        wordDictionary.addWord("bar");

        boolean b1 = wordDictionary.search("pattern");
        boolean b2 =wordDictionary.search("foo");
        boolean b3 =wordDictionary.search("f.o");
        boolean b4 =wordDictionary.search("fo.");

        return;
    }
}




