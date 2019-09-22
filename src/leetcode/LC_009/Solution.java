package leetcode.LC_009;

import java.util.ArrayList;

public class Solution {

    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int[] revNums = new int[(int)Math.log10(x) + 1];
        int n = 0;
        while (x > 0) {
            int r = x % 10;
            revNums[n++] = r;
            x /= 10;
        }

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (revNums[i] != revNums[j])
                return false;
        }
        return true;
    }

    static boolean isPalindromeArrayList(int x) {
        if (x < 0) return false;

        ArrayList<Integer> revNums = new ArrayList<>();
        while (x > 0) {
            int r = x % 10;
            revNums.add(r);
            x /= 10;
        }

        for (int i = 0, j = revNums.size() - 1; i < j; i++, j--) {
            if (!revNums.get(i).equals(revNums.get(j)))
                return false;
        }
        return true;
    }
}
