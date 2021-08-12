package leetcode.LC_079

import java.util.*

/**
 * 79. Word Search
 */
class Solution79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (r in board.indices) {
            for (c in board[0].indices) {
                if (search(board, word, r, c)) {
                    return true;
                }
            }
        }
        return false
    }

    fun search(board: Array<CharArray>, word: String, row: Int, col: Int): Boolean {
        // Memorize visited coordinates
        val visited = Array(board.size) {
            BooleanArray(board[0].size) {
                false
            }
        }

        // DFS
        val stack = Stack<State>()
        stack.push(State(false, 0, row, col))

        while (!stack.empty()) {
            val state = stack.pop()

            if (state.backtrack) {
                visited[state.row][state.col] = false
                continue
            }

            if (state.index == word.length)
                return true

            if (state.row < 0
                    || state.row >= board.size
                    || state.col < 0
                    || state.col >= board[0].size)
                continue

            if (visited[state.row][state.col])
                continue

            if (word[state.index] != board[state.row][state.col])
                continue

            visited[state.row][state.col] = true
            stack.push(state.copy(backtrack = true))

            for (array in SEARCH_DIRECTIONS) {
                stack.push(State(
                        false,
                        state.index + 1,
                        state.row + array[0],
                        state.col + array[1]
                ))
            }
        }
        return false
    }

    companion object {
        val SEARCH_DIRECTIONS = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, -1),
                intArrayOf(-1, 0),
                intArrayOf(1, 0)
        )
    }
}

data class State(
        val backtrack: Boolean,
        val index: Int,
        val row: Int,
        val col: Int
)