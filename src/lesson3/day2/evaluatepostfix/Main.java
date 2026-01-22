package lesson3.day2.evaluatepostfix;

import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    static double evaluate(String postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix.split(" ")) {
            //whether token is an operand or operator
            if (token.matches("\\d+")){
                stack.push(Double.parseDouble(token));
            } else if (token.matches("[+\\-*/^]")) {
                if (stack.size() < 2) {
                    System.out.println("Invalid expression:");
                    throw new EmptyStackException();
                }
                //pop two times
                double rightOperand = stack.pop();
                double leftOperand = stack.pop();
                switch (token) {
                    case "+": stack.push(leftOperand + rightOperand); break;
                    case "-": stack.push(leftOperand - rightOperand); break;
                    case "*": stack.push(leftOperand * rightOperand); break;
                    case "/": stack.push(leftOperand / rightOperand); break;
                    case "^": stack.push(Math.pow(leftOperand, rightOperand)); break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println( evaluate("10 20 30 2 1 * + / ^"));

        System.out.println("b2a".matches(".*[0-9].*"));

    }
}
