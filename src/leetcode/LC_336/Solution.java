package leetcode.LC_336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by naco_siren on 9/24/17.
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> r0 = palindromePairs(new String[]{"a", ""});
        List<List<Integer>> r1 = palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
        List<List<Integer>> r2 = palindromePairs(new String[]{"bat", "tab", "cat"});

        return;
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        /* Use a HashSet to avoid duplicate results  */
        HashSet<List<Integer>> results = new HashSet<>();
        if (words == null) return new ArrayList<>(results);
        int n = words.length;

        /* Maintain a HashMap for indexing reversed strings */
        HashMap<String, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++)
            map.put(new StringBuilder(words[i]).reverse().toString(), i);

        /* Find the buddis for each word */
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                /* Split the word into a left part and a right part */
                String sub1 = word.substring(0, j);
                String sub2 = word.substring(j);

                /* If the right part is palindrome and left part has a buddy */
                if (isPalindrome(sub2)) {
                    Integer r = map.get(sub1);
                    if (r != null && i != r) {
                        ArrayList<Integer> pair = new ArrayList<>(2);
                        pair.add(i); pair.add(r); results.add(pair);
                    }
                }

                /* If the left part is palindrome and right part has a buddy */
                if (isPalindrome(sub1)) {
                    Integer l = map.get(sub2);
                    if (l != null && i != l) {
                        ArrayList<Integer> pair = new ArrayList<>(2);
                        pair.add(l); pair.add(i); results.add(pair);
                    }
                }
            }
        }
        return new ArrayList<>(results);
    }

    public static boolean isPalindrome(String word) {
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
}
