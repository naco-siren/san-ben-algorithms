package leetcode.LC_716;

import java.util.Stack;

/**
 * 716. Max Stack
 *
 * using two stacks
 */
class Solution716 {

    Stack<Integer> vals;
    Stack<Integer> maxs;

    /** initialize your data structure here. */
    public Solution716() {
        vals = new Stack<>();
        maxs = new Stack<>();
    }

    public void push(int x) {
        vals.push(x);

        if (maxs.isEmpty()) {
            maxs.push(x);
        } else {
            maxs.push(Math.max(x, maxs.peek()));
        }
    }

    public int pop() {
        maxs.pop();
        return vals.pop();
    }

    public int top() {
        return vals.peek();
    }

    public int peekMax() {
        if (maxs.isEmpty() || vals.isEmpty())
            throw new IllegalStateException("Stack is empty!");

        return maxs.peek();
    }

    public int popMax() {
        if (maxs.isEmpty() || vals.isEmpty())
            throw new IllegalStateException("Stack is empty!");

        // Cache popped non-max values
        Stack<Integer> temp = new Stack<>();
        while (top() != maxs.peek())
            temp.push(pop());

        // Pop target max value
        final int max = pop();

        // Push back non-max values
        while (!temp.isEmpty())
            push(temp.pop());

        return max;
    }
}
