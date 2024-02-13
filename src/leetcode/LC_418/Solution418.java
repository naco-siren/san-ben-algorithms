package leetcode.LC_418;

/**
 * 418. Sentence Screen Fitting
 */
public class Solution418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int times = 0;

        int idx = 0;    // Word counter
        int r = 0, c = 0;
        while (r < rows) {
            final int curWordLen = sentence[idx].length();
            if (curWordLen > cols) {
                break;
            }

            // If current word fits
            if (c == 0) {
                c += curWordLen;
                idx++;
            } else if (c > 0 && c + 1 + curWordLen <= cols) {
                c += (1 + curWordLen);
                idx++;
            } else {
                c = 0;
                r++;
            }

            // Reset word counter
            if (idx == sentence.length) {
                times++;
                idx = 0;
            }
        }
        return times;
    }
}
