package hackerrank;

/**
 * Created by naco_siren on 8/27/17.
 */
public class JumpingJack {
    public static void main(String[] args) {




        return;
    }

    public static int jump(int n, int k) {
        boolean avoidance = false;
        int step = 0;
        for (int i = 1; i <= n; i++) {
            step += i;
            if (step == k) avoidance = true;
        }

        if (avoidance == true) step -= 1;

        return step;
    }

    public static int jump2(int n, int k) {
        /* Intialize the DP */
        int[] dp = new int[n + 1];
        dp[0] = 0;

        /* DP */
        for (int i = 1; i <= n; i++) {
            int j = i;

            do {
                j--;
                dp[i] = dp[j] + i;
            } while (dp[i] == k && j > 0);

        }
        return dp[n];
    }
}
