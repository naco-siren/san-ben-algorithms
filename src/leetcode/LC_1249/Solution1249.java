package leetcode.LC_1249;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 */
public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        // Remove extra right parentheses
        String rightRemoved = removeExtraRights(s);

        // Remove extra left parentheses
        String leftRemoved = removeExtraLefts(rightRemoved);

        return leftRemoved;
    }

    private String removeExtraRights(String s) {
        StringBuilder builder = new StringBuilder();
        int openLefts = 0;
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            switch(ch) {
                case ')':
                    if (openLefts > 0) {
                        openLefts--;
                        builder.append(ch);
                    }

                    break;
                case '(':
                    ++openLefts;
                    builder.append(ch);
                    break;
                default:
                    if (ch >= 'a' && ch <= 'z')
                        builder.append(ch);
                    break;
            }
        }
        return builder.toString();
    }

    private String removeExtraLefts(String s) {
        StringBuilder builder = new StringBuilder();
        int openRights = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            final char ch = s.charAt(i);
            switch(ch) {
                case '(':
                    if (openRights > 0) {
                        openRights--;
                        builder.append(ch);
                    }

                    break;
                case ')':
                    ++openRights;
                    builder.append(ch);
                    break;
                default:
                    if (ch >= 'a' && ch <= 'z')
                        builder.append(ch);
                    break;
            }
        }
        return builder.reverse().toString();
    }
}
