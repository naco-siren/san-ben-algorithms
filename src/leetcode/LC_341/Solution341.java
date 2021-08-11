package leetcode.LC_341;

import java.util.*;


/**
 * 341. Flatten Nested List Iterator
 *
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new Solution341(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class Solution341 implements Iterator<Integer> {

    Stack<NestedInteger> _stack;

    public Solution341(List<NestedInteger> nestedList) {
        _stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            _stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return _stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!_stack.isEmpty() && !_stack.peek().isInteger()) {
            List<NestedInteger> top = _stack.pop().getList();
            for (int i = top.size() - 1; i >= 0; i--) {
                _stack.push(top.get(i));
            }
        }
        return !_stack.isEmpty();
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
