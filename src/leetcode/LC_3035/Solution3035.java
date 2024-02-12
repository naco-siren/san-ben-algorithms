package leetcode.LC_3035;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 3035. Maximum Palindromes After Operations
 */
public class Solution3035 {
    public int maxPalindromesAfterOperations(String[] words) {
        int evenCharsCount = 0;
        Set<Character> oddChars = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String word : words) {
            pq.offer(word.length());

            for (char ch : word.toCharArray()) {
                if (oddChars.contains(ch)) {
                    evenCharsCount += 2;
                    oddChars.remove(ch);
                } else {
                    oddChars.add(ch);
                }
            }
        }
        int oddCharsCount = oddChars.size();

        int result = 0;
        while (!pq.isEmpty()) {
            final int quota = pq.poll();
            if ((quota & 1) == 1) {
                if (oddCharsCount > 0 && evenCharsCount >= quota - 1) {
                    oddCharsCount -= 1;
                    evenCharsCount -= (quota - 1);
                    result++;
                } else if (evenCharsCount >= quota) {
                    oddCharsCount += 1;
                    evenCharsCount -= (quota - 1);
                    result++;
                }
            } else {
                if (evenCharsCount >= quota) {
                    evenCharsCount -= quota;
                    result++;
                }
            }
        }
        return result;
    }
}
