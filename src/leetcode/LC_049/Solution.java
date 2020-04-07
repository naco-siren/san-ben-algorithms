package leetcode.LC_049;

import java.util.*;

/**
 * 49. Group Anagrams
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>(strs.length);
        for (String str : strs) {
            // Obtain String with sorted chars of current string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String key = new String(chars);

            // Update it to the map
            List<String> anagrams = groups.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            groups.put(key, anagrams);
        }

        return new ArrayList<>(groups.values());
    }
}
