package StackAndQueue.L18;

import java.util.Stack;

public class paranthesischeck {

    // Method to check if the given string has balanced brackets
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '{' || i == '[') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && (
                        (stack.peek() == '(' && i == ')') ||
                                (stack.peek() == '{' && i == '}') ||
                                (stack.peek() == '[' && i == ']')
                )) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Method to calculate the minimum number of swaps to balance brackets
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return ((stack.size() / 2) + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println("Good one");
    }
}

