package lintcode;

/**
 * Created by naco_siren on 8/31/17.
 */
public class LC_77 {

    public static void main(String[] args) {
        int r1 = longestCommonSubsequence("ABCDEFG", "XDBCOPFA");
        return;
    }

    public static int longestCommonSubsequence(String A, String B) {
        int m = A.length(), n = B.length();
        int f[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m][n];
    }
}

