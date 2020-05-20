package leetcode.LC_211;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by naco_siren on 9/26/17.
 */
public class WordDictionaryTest {

    @Test
    public void test_1() {
        // Your WordDictionary object will be instantiated and called as such:
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("word");
        wordDictionary.addWord("foo");
        wordDictionary.addWord("bar");

        assertFalse(wordDictionary.search("pattern"));
        assertTrue(wordDictionary.search("foo"));
        assertTrue(wordDictionary.search("f.o"));
        assertTrue(wordDictionary.search("fo."));

        return;
    }
}




