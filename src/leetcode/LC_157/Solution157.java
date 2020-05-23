package leetcode.LC_157;

/**
 * 157. Read N Characters Given Read4
 */
class Solution157 {
    final String srcString;
    public Solution157(String srcString) {
        this.srcString = srcString;
    }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int read(char[] buf, int n) {
        // Use a buffer of size 4 to cache the content just read
        char[] temp = new char[4];

        int total = 0;
        while (total < n) {
            int tempCount = read4(temp);

            // PAY ATTENTION TO HOW THIS LINE GUARDS THE CASE OF THE LAST READ WHERE:
            // `read4` still has plenty to return, but `n` specifies only a little.
            //
            // Read until satisfied (total == n) or used up (tempOffset == tempCount)
            int tempOffset = 0;
            while (total < n && tempOffset < tempCount)     // See unit test case "read_guards_last_read".
                buf[total++] = temp[tempOffset++];

            // If source file read up, exit loop
            if (tempCount < 4)
                break;
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
