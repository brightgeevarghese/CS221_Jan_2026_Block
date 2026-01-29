import java.util.EmptyStackException;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    static double evaluatePostfixExpression(String postfix) {
//        Stack<Double> stack = new Stack<>();
//        for (String token : postfix.split(" ")) {
//            //whether token is an operand or operator
//            if (token.matches("\\d+")){
//                stack.push(Double.parseDouble(token));
//            } else if (token.matches("[+\\-*/^]")) {
//                //write your code here
//
//            }
//        }
//        return stack.pop();
//    }
//    public static void main(String[] args) {
//        System.out.println( evaluatePostfixExpression("2 3 + 20 2 3 ^ - * 5 /"));
//    }
//}