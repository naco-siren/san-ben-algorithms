package java_lang;

import java.util.Stack;

/**
 * Created by naco_siren on 7/16/17.
 */
public class stack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        stack.push(null);
        stack.push(5);
        stack.push(7);

        while (stack.isEmpty() == false) {
            Integer i = stack.pop();

            if (i == null)
                continue;
        }

        stack.clear();

        return;
    }

}
