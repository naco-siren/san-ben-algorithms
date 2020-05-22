package leetcode.LC_157;

/**
 * 157. Read N Characters Given Read4
 */
class Solution157 {
    final String srcString;

    public Solution157(String srcString) {
        this.srcString = srcString;
    }

    int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] temp = new char[4];  // Use a buffer of size 4 to cache the content just read

        while (!eof && total < n) {
            int count = read4(temp);

            if (count < 4)
                eof = true;

            // PAY ATTENTION TO HOW THIS LINE GUARDS THE CASE OF THE LAST READ WHERE:
            // `read4` still has plenty to return, but `n` specifies only a little.
            //
            // See unit test case "read_guards_last_read".
            //
            count = Math.min(count, n - total);

            for (int i = 0; i < count; i++)
                buf[total++] = temp[i];
        }
        return total;
    }

    /**
     * DUMMY
     */
    private int read4(char[] buf) {
        return -1;
    }
}
