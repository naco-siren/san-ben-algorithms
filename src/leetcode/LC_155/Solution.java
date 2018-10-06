package leetcode.LC_155;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int r1 = minStack.getMin();   // --> Returns -3.
        minStack.pop();
        int r2 = minStack.top();      // --> Returns 0.
        int r3 = minStack.getMin();   // --> Returns -2.
    }
}
