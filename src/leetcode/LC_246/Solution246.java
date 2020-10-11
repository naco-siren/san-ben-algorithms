package leetcode.LC_246;

import java.util.*;

/**
 * 246. Strobogrammatic Number
 */
public class Solution246 {
    /**
     * Approach #1: Array
     */
    private static final char[][] SYMM_PAIRS = new char[][]{
            new char[]{'0', '0'},
            new char[]{'1', '1'},
            new char[]{'6', '9'},
            new char[]{'8', '8'},
            new char[]{'9', '6'},
    };

    public boolean isStrobogrammatic(String num) {
        outer: for (int l = 0, r = num.length() - 1; l <= r; l++, r--) {
            final char ch1 = num.charAt(l), ch2 = num.charAt(r);

            for (char[] pair : SYMM_PAIRS) {
                if (pair[0] == ch1 && pair[1] == ch2)
                    continue outer;
            }
            return false;
        }
        return true;
    }


    /**
     * Approach #2: Map
     */
    Map<Character, Character> map = new HashMap<>();
    public Solution246() {
        map.put('6','9');
        map.put('1','1');
        map.put('8','8');
        map.put('9','6');
        map.put('0','0');
    }
    public boolean isStrobogrammatic2(String num) {
        int lo = 0; int hi = num.length()-1;
        while(lo <= hi && lo < num.length() && hi >= 0){
            if(!map.containsKey(num.charAt(lo))) return false;
            if(num.charAt(hi) != map.get(num.charAt(lo))) return false;
            lo++;
            hi--;
        }
        return true;
    }
}
