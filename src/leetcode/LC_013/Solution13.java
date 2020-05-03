package leetcode.LC_013;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
class Solution13 {
    int romanToInt(String s) {
        // Initialize a lookup table for each character
        final Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        // Iterate through each char
        int result = 0;
        int prev = 0;   // Memorize previous digit's value
        for (int i = 0; i < s.length(); i++) {
            final int digit = values.get(s.charAt(i));
            result += digit;
            if (digit > prev)
                result -= prev * 2;

            prev = digit;
        }
        return result;
    }
}
