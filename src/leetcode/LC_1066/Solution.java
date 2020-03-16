package leetcode.LC_1066;

/**
 * 1055. Shortest Way to Form String
 */
public class Solution {
    public int shortestWay(String source, String target) {
        char[] srcChars = source.toCharArray();
        char[] tgtChars = target.toCharArray();

        int result = 0;
        for (int i = 0; i < tgtChars.length; ){
            int origI = i;
            for (int j = 0; j < srcChars.length; j++) {
                if (i < tgtChars.length && srcChars[j] == tgtChars[i]) {
                    i++;
                }
            }

            // If pointer `i` didn't move, apparently this search didn't find a single matching (according to line 16).
            if (origI == i) {
                return -1;
            }

            result++;
        }
        return result;
    }

    public int shortestWay2(String source, String target) {
        int result = 0;

        int i = 0, j = 0;
        boolean engaging = false;
        while (j < target.length()) {
            if (i == source.length()) {
                engaging = false;
                result++;
                i = 0;
            }

            while (i < source.length()) {
                if (source.charAt(i) == target.charAt(j)) {
                    engaging = true;
                    break;
                } else {
                    i++;
                }
            }

            if (i == source.length()) {
                if (engaging) {
                    engaging = false;
                    result++;
                    i = 0;
                } else {
                    return -1;
                }
            } else if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                return -1;
            }
        }
        return result + 1;
    }
}
