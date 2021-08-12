package leetcode.LC_079

import org.junit.Assert.*
import org.junit.Test

class Solution79Test {
    @Test
    fun case1() {
       assertTrue(Solution79().exist(
                board = arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                ),
                word = "ABCCED"
       ))
    }

    @Test
    fun case2() {
        assertFalse(Solution79().exist(
                board = arrayOf(
                        charArrayOf('A', 'B', 'C', 'E'),
                        charArrayOf('S', 'F', 'C', 'S'),
                        charArrayOf('A', 'D', 'E', 'E')
                ),
                word = "ABCB"
        ))
    }
}