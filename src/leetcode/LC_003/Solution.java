package leetcode.LC_003;


import java.util.HashMap;

public class Solution {

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int maxLen = 0;

        HashMap<Character, Integer> lastPos = new HashMap<>();

        for (int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (lastPos.containsKey(ch) && lastPos.get(ch) >= l) {
                l = lastPos.get(ch) + 1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            lastPos.put(ch, r);
        }
        return maxLen;
    }
}
