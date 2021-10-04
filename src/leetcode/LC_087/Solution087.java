package leetcode.LC_087;

/**
 * 87. Scramble String
 *
 * Created by naco_siren on 7/23/17.
 */
public class Solution087 {
    /**
     * A dynamic programming solution
     */
    public boolean isScramble(String s1, String s2) {
        int L = s1.length();
        if (L == 0) return true;
        if (L == 1) return s1.charAt(0) == s2.charAt(0);

        /* Initialize DP */
        boolean[][][] dp = new boolean[L][][];
        for (int i = 0; i < L; i++) {
            dp[i] = new boolean[L][];
            for (int j = 0; j < L; j++) {
                dp[i][j] = new boolean[L];

                /* dp[i][j][0] : substring with length of 1, i.e. only the character itself */
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }

        /* Check the substring from shortest (2) to longest (L);
           Use "l" to indicate the length of it */
        for (int l = 2; l <= L; l++) {

            /* "i" : s1's substring start index */
            for (int i = 0; i + l - 1 < L; i++) {

                /* "j" : s2's substring start index */
                for (int j = 0; j + l - 1 < L; j++) {

                    /* "k" : grow from 1 to "l";
                       consider marginal effect at each step */
                    for (int k = 1; k < l; k++) {
                        /* not swap */
                        if (dp[i][j][k-1] && dp[i+k][j+k][l-k-1])
                            dp[i][j][l-1] = true;

                        /* swap */
                        if (dp[i][j+l-k][k-1] && dp[i+k][j][l-k-1])
                            dp[i][j][l-1] = true;
                    }
                }
            }
        }

        /* Compare the s1 and s2's substrings that both start at 0 with length L */
        return dp[0][0][L-1];
    }

    /**
     * A recursive solution
     */
    public boolean isScramble2(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int len = s1.length();

        /* Check if two strings contain different characters */
        int[] letters = new int[26];
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (letters[i] != 0)
                return false;

        /* Recursively compare */
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }
}
