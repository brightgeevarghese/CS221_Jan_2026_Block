package lesson3.day1.palindrome;

import java.util.Stack;

public class Main {
    static boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return input.contentEquals(sb);
    }
    public static void main(String[] args) {
        String input = "computer";
        System.out.println(isPalindrome(input));//true/false
    }
}
