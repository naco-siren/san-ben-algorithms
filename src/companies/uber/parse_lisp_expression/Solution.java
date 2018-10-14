package companies.uber.parse_lisp_expression;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s1 = new Solution("(* 1 2 3)");
        int r1 = s1.calc(); // 1 * 2 * 3 = 6

        Solution s2 = new Solution("(* (- 4 3) 2 (+ 1 2))");
        int r2 = s2.calc(); // (4 - 3) * 2 * (1 + 2) = 6

        Solution s3 = new Solution("(+ 12 5 0)");
        int r3 = s3.calc(); // 17

        Solution s4 = new Solution("(+ (- 6 3) (* 2 (+ 4 3)) (+ 1 2))");
        int r4 = s4.calc(); // 20
    }


    Solution(String input) {
        if (input == null || input.length() == 0)
            throw new IllegalArgumentException("Input string mustn't be empty!");

        this._str = input.trim();
        this._cursor = 0;
    }

    private String _str;
    private int _cursor;

    int calc() {
        Stack<Node> stack = new Stack<>();

        while (_cursor < _str.length()) {
            char ch = _str.charAt(_cursor);
            switch (ch) {
                case '(':
                    stack.push(new Node(_str.charAt(++_cursor)));
                    _cursor++;
                    break;

                case ')':
                    LinkedList<Node> operands = new LinkedList<>();
                    while (!stack.peek()._isOp)
                        operands.addFirst(stack.pop());
                    if (operands.isEmpty())
                        throw new IllegalStateException("Each operator must have at least 1 operand!");

                    Node operator = stack.pop();
                    operator._operands = operands;

                    Node value = new Node(operator.getValue());
                    if (stack.isEmpty())
                        return value._num;

                    stack.push(value);
                    _cursor++;
                    break;

                case ' ':
                    _cursor++;
                    break;

                default:
                    StringBuilder builder = new StringBuilder();
                    while (_cursor < _str.length() && Character.isDigit(_str.charAt(_cursor))) {
                        builder.append(_str.charAt(_cursor++));
                    }
                    stack.add(new Node(Integer.parseInt(builder.toString())));
                    break;
            }
        }
        return -1;
    }

    private static class Node {
        boolean _isOp;
        char _op;
        int _num;

        List<Node> _operands;

        Node(char op) {
            _isOp = true;
            _op = op;
        }

        Node(int num) {
            _isOp = false;
            _num = num;
        }

        int getValue() {
            if (!_isOp)
                return _num;

            int operandL = _operands.get(0)._num;
            for (int i = 1; i < _operands.size(); i++) {
                int operandR = _operands.get(i).getValue();
                switch (_op) {
                    case '+':
                        operandL += operandR;
                        break;
                    case '-':
                        operandL -= operandR;
                        break;
                    case '*':
                        operandL *= operandR;
                        break;
                    case '/':
                        operandL /= operandR;
                        break;
                    default:
                        throw new IllegalStateException("This should never happen!");
                }
            }
            return operandL;
        }

        @Override
        public String toString() {
            return _isOp ? "[ " + _op + " ]" : String.valueOf(_num);
        }
    }
}
