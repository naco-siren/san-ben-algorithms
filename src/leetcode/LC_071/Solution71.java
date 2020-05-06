package leetcode.LC_071;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 71. Simplify Path
 */
class Solution71 {
    String simplifyPath(String path) {
        String[] dirs = path.split("/");

        // Use a stack to emulate `cd` commands
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.isEmpty()) {
                continue;
            } else if (".".equals(dir)) {
                continue;
            } else if ("..".equals(dir)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(dir);
            }
        }

        // Reverse the stack with a deque
        Deque<String> deque = new LinkedList<>();
        while (!stack.isEmpty())
            deque.offerLast(stack.pop());

        if (deque.isEmpty())
            return "/";

        // Output into a String
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty())
            builder.append("/" + deque.pollLast());
        return builder.toString();
    }
}
