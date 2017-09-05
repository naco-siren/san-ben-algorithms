package leetcode;

/**
 * Created by naco_siren on 7/23/17.
 */
public class LC_87 {
    public static void main(String[] args) {
        LC_87 lc = new LC_87();
        System.out.println(lc.isScramble("great", "rgate"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
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
