package leetcode.LC_065;

/**
 * 65. Valid Number
 */
class Solution65 {
    public boolean isNumber(String s) {
        s = s.trim();

        // 1. Separate decimal before `e` from power after `e`
        String[] parts = splitE(s);
        if (parts == null)
            return false;

        // 2. Decimal before `e`
        boolean isDecimalBeforeEVerified = verifyDecimal(parts[0], true);
        if (!isDecimalBeforeEVerified)
            return false;

        if (parts.length < 2)
            return true;

        // 3. Power after `e`, if exist
        return verifyDecimal(parts[1], false);
    }

    /**
     * Separate input string into at most two parts that
     * @param s
     * @return split substrings with size of 1 or 2
     */
    private String[] splitE(String s) {
        // Find the first occurrence of `e`
        int e = -1;
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            } else if (ch == '-' || ch == '+') {
                continue;
            } else if (ch == '.') {
                continue;
            } else if (ch == 'e') {
                if (e == -1) {
                    e = i;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

        if (e == -1)
            return new String[]{s};
        else
            return new String[]{s.substring(0, e), s.substring(e + 1)};
    }

    private boolean verifyDecimal(String s, final boolean allowDecimalPart) {
        // 0. Corner cases
        if (s == null || s.isEmpty())
            return false;

        // 1. Sign
        boolean hasSign = false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            hasSign = true;

            if (s.length() == 1 || s.charAt(1) == '-' || s.charAt(1) == '+')
                return false;
        }
        if (hasSign)
            s = s.substring(1);

        // 2. Whole number part
        int i = 0;
        int decimal = -1;
        for (; i < s.length(); i++) {
            final char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            } else if (ch == '.') {
                decimal = i;
                break;
            } else {
                return false;
            }
        }
        if (decimal == -1)
            return true;

        // 3. Decimal part
        if (!allowDecimalPart)
            return false;

        int j = decimal + 1;
        for (; j < s.length(); j++) {
            final char ch = s.charAt(j);
            if (ch >= '0' && ch <= '9') {
                continue;
            } else {
                return false;
            }
        }

        // Whole number part has to be non-empty if decimal part is empty
        return i > 0 || j > decimal + 1;
    }
}
