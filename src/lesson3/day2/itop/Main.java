package lesson3.day2.itop;

import java.util.Stack;

public class Main {
    static int precedence(char op) {
        return switch (op) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }
    static String solve(String infixExpression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();
        for (char c : infixExpression.toCharArray()) {
            //Case 1: Check whether its an operand(number or alphabet)
            if (Character.isLetterOrDigit(c)) {
                postfixExpression.append(c);
            }
            // Case 2: Opening parenthesis or bracket -> push to stack
            else if (c == '(' || c == '[') {
                stack.push(c);
            } // Case 3: Closing parenthesis ')'
            // Pop operators until matching '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    Character ch = stack.pop();
                    postfixExpression.append(ch);
                }
                // If '(' is not found, expression is invalid
                if(stack.isEmpty()) {
                    return "Invalid Expression";
                }
                stack.pop();// discard '('
            }            // Case 4: Closing bracket ']'
            // Pop operators until matching '[' is found
            else if (c == ']') {
                while (!stack.isEmpty() && stack.peek() != '[') {
                    postfixExpression.append(stack.pop());
                }
                // If '[' is not found, expression is invalid
                if(stack.isEmpty()) {
                    return "Invalid Expression";
                }
                stack.pop(); // discard '['
            }
            // Case 5: Operator (+, -, *, /, ^)
            else if ("+-*/^".indexOf(c) >= 0) {
                // Pop operators from stack while:
                // 1. Stack is not empty
                // 2. Top is not an opening bracket
                // 3. Higher precedence operator exists on stack OR
                //    Same precedence and current operator is left-associative
                while (
                        !stack.isEmpty()
                                && (stack.peek() != '(' && stack.peek() != '[')
                                && (
                                        precedence(c) < precedence(stack.peek())
                                        || (
                                                c != '^' && precedence(c) == precedence(stack.peek())
                                        )
                                )
                ) {
                    postfixExpression.append(stack.pop());
                }
                // Push current operator onto stack
                stack.push(c);

            }

        }
        // Pop remaining operators from stack
        // If any opening bracket remains, expression is invalid
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == '[') {
                return "Invalid Expression";
            }
            postfixExpression.append(stack.pop());
        }
        return postfixExpression.toString();
    }

    static void test(String infix) {
        System.out.println(infix + " -> " + solve(infix));
    }

    public static void main(String[] args) {
        test("a^b*c-d/e+f");
        test("(a+b)");
        test("a+b)");
        test("((a+b)-c)");
        test("([a+b])");
        test("([a+b)]");
        test("(a+b");
    }
}
