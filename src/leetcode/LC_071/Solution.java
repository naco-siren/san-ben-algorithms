package leetcode.LC_071;

import java.util.Stack;

/**
 * Created by naco_siren on 7/14/17.
 */
public class Solution {
    public static void main(String[] args) {
        String r1 = simplifyPath("/...");

        return;
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            } else if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (stack.isEmpty() == false)
                    stack.pop();
            } else {
                stack.push(dir);
            }
        }

        if (stack.isEmpty() == true) {
            return "/";
        } else {
            String result = "";
            while (stack.isEmpty() == false) {
                result = "/" + stack.pop() + result;
            }
            return result;
        }
    }
}
