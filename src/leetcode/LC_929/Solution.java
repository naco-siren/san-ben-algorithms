package leetcode.LC_929;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        int uniques = 0;
        Set<String> set = new HashSet<>(emails.length);
        for (String email : emails) {
            final String equivalent = processEmail(email);
            if (!set.contains(equivalent)) {
                set.add(equivalent);
                uniques++;
            }
        }
        return uniques;
    }

    private String processEmail(String email) {
        StringBuilder builder = new StringBuilder();
        boolean inLocal = true, ignore = false;
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (ch == '@') {
                builder.append('@');
                inLocal = false;
                ignore = false;
            } else if (ch == '+') {
                if (inLocal)
                    ignore = true;
            } else if (ch == '.') {
                if (!inLocal)
                    builder.append(ch);
            } else {
                if (!ignore)
                    builder.append(ch);
            }
        }
        return builder.toString();
    }
}
