package hackerrank;

/**
 * Created by naco_siren on 8/27/17.
 */
public class StringSimilarity {
    public static void main(String[] args) {
        stringSimilarity(new String[]{"ababaa", "aa"});
        return;
    }

    static int[] stringSimilarity(String[] inputs) {
        int N = inputs.length;
        int[] results = new int[N];
        for (int n = 0; n < N; n++) {
            String input = inputs[n];
            int len = input.length();

            for (int i = 0; i < len; i++) {
                String suffix = input.substring(i, len);
                results[n] += calcSimilarity(input, suffix);
            }
        }
        return results;
    }

    static int calcSimilarity(String a, String b) {
        int m = a.length(), n = b.length();
        int similarity = 0;
        for (int i = 0; i < m && i < n; i++) {
            if (a.charAt(i) == b.charAt(i))
                similarity++;
            else
                break;
        }
        return similarity;
    }
}
