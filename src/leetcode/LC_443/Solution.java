package leetcode.LC_443;

/**
 * https://leetcode.com/problems/string-compression/
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] input1 = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int r1 = solution.compress(input1);

        return;
    }


    public int compress(char[] chars) {
        int w = 0, i = 0, j = 0, size;
        int temp, digits;

        while (j < chars.length) {
            while (++j < chars.length && chars[j] == chars[i]);

            size = j - i;
            if (size == 0) {
                break;

            } else if (size == 1) {
                // Write a single char
                chars[w++] = chars[i];

                // Update pointers
                i = j;

            } else {
                chars[w++] = chars[i];

                // Get digits
                temp = size; digits = 0;
                while (temp > 0) {
                    temp /= 10;
                    digits++;
                }

                // Write size reversely
                temp = w;
                for (w = w + digits - 1; w >= temp; w--, size /= 10)
                    chars[w] = (char) ('0' + size % 10);
                w = w + digits + 1;

                // Update pointers
                i = j;
            }

        }
        return w;
    }
}