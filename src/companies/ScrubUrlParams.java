package companies;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ScrubUrlParams {

    public static String scrub(String urlString, Set<String> sensitiveKeys) {
        final String[] mainParts = urlString.split("\\?");
        final String[] queryParts = mainParts[1].split("#");
        final String query = queryParts[0];
        final boolean hasFragment = queryParts.length > 1;

        StringBuilder result = new StringBuilder(mainParts[0] + "?");
        int index = 0;

        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        boolean inValue = false;
        while (index < query.length()) {
            final char ch = query.charAt(index);

            if (ch == '&') {
                if (key.length() > 0 && value.length() > 0) {
                    final String k = key.toString(), v = value.toString();
                    result.append(k);
                    result.append('=');

                    final String newV = sensitiveKeys.contains(k) ? scrubValue(v) : v;
                    result.append(newV);
                }

                result.append('&');

                key.setLength(0);
                value.setLength(0);
                inValue = false;

            } else if (ch == '=') {
                inValue = true;
            } else {
                if (inValue) {
                    value.append(ch);
                } else {
                    key.append(ch);
                }
            }

            index++;
        }

        // Handle the last key-value pair without dangling ampersand
        if (key.length() > 0 && value.length() > 0) {
            final String k = key.toString(), v = value.toString();
            result.append(k);
            result.append('=');

            final String newV = sensitiveKeys.contains(k) ? scrubValue(v) : v;
            result.append(newV);
        }

        if (hasFragment)
            result.append("#").append(queryParts[1]);
        return result.toString();
    }

    private static String scrubValue(String value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            builder.append("*");
        }
        return builder.toString();
    }

    @Test
    public void withoutAnySpecialParts() {
        final String input = "http://www.company.com/a.html?user=Alice&year=2008";
        Set<String> keys = new HashSet<>();
        keys.add("year");
        assertEquals(
                "http://www.company.com/a.html?user=Alice&year=****",
                scrub(input, keys)
        );
    }

    @Test
    public void multipleParams() {
        final String input = "http://www.company.com:81/a/b/c.html?user=Alice&year=2008&password=114514";
        Set<String> keys = new HashSet<>();
        keys.add("user");
        keys.add("password");
        assertEquals(
                "http://www.company.com:81/a/b/c.html?user=*****&year=2008&password=******",
                scrub(input, keys)
        );
    }

    @Test
    public void withoutPortWithFragment() {
        final String input = "http://www.company.com/a.html?user=Alice&year=2008#p2";
        Set<String> keys = new HashSet<>();
        keys.add("year");
        assertEquals(
                "http://www.company.com/a.html?user=Alice&year=****#p2",
                scrub(input, keys)
        );
    }

    @Test
    public void withTanglingAmpersand() {
        final String input = "http://www.company.com/a.html?user=Alice&year=2008&";
        Set<String> keys = new HashSet<>();
        keys.add("year");
        assertEquals(
                "http://www.company.com/a.html?user=Alice&year=****&",
                scrub(input, keys)
        );
    }

    @Test
    public void withFragmentAndTanglingAmpersand() {
        final String input = "http://www.company.com:81/a/b/c.html?user=Alice&year=2008#p2";
        Set<String> keys = new HashSet<>();
        keys.add("year");
        assertEquals(
                "http://www.company.com:81/a/b/c.html?user=Alice&year=****#p2",
                scrub(input, keys)
        );
    }
}
