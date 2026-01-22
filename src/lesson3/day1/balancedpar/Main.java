package lesson3.day1.balancedpar;

import java.util.Stack;

public class Main {
    static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '[' || c == '(') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop()!= '['){
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
//        String inputExpression = "[a +  b * c + d]";
//        System.out.println(isBalanced(inputExpression));
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.toString());
    }
}
