package StackAndQueue.L21;

import java.util.Stack;

public class StackOperations {

    // Insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> s, int x) {
        if (s.isEmpty()) {
            s.push(x);
        } else {
            int temp = s.pop();
            insertAtBottom(s, x);
            s.push(temp);
        }
    }

    // Reverse the stack
    public static void reverse(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int temp = s.pop();
            reverse(s);
            insertAtBottom(s, temp);
        }
    }

    // Insert an element into a sorted stack
    public static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || s.peek() < x) {
            s.push(x);
        } else {
            int temp = s.pop();
            sortedInsert(s, x);
            s.push(temp);
        }
    }

    // Sort the stack
    public static void sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Example usage
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        reverse(stack);
        System.out.println("Reversed Stack: " + stack);

        sort(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
