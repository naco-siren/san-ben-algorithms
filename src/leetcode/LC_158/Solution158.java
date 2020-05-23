package leetcode.LC_158;

/**
 * 158. Read N Characters Given Read4 II - Call multiple times
 */
class Solution158 {
    final String srcString;
    public Solution158(String srcString) {
        this.srcString = srcString;
    }

    // Again: a buffer of size 4 to cache the content just read
    private char[] temp = new char[4];

    // =====================
    // MEMORIZE THE STATUS OF LAST READ:
    private int tempCount = 0;          // 1. how many valid chars are there in `temp`.
    private int tempOffset = 0;         // 2. where is the offset of this `temp`.
    // =====================

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            // =====================
            // If `offset` is reset, we need to perform another round of read.
            if (tempOffset == 0)
            // =====================
                tempCount = read4(temp);


            // Again, read until satisfied (total == n) or used up (tempOffset == tempCount)
            while (total < n && tempOffset < tempCount)
                buf[total++] = temp[tempOffset++];


            // =====================
            // Reset `offset` on using up all the chars in `temp`
            if (tempOffset == tempCount)
                tempOffset = 0;
            // =====================


            // Again: If source file read up, exit loop
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
