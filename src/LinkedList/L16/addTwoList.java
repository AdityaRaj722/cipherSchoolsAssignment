package LinkedList.L16;

public class addTwoList {

    // Definition for singly-linked list node.
    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse the linked list
    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> curr = head;
        Node<T> prev = null;
        Node<T> forward = null;

        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    // Insert a new node at the end of the linked list
    public static void insertAtTail(Node<Integer> head, Node<Integer> tail, int num) {
        Node<Integer> newNode = new Node<>(num);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Add two linked lists
    public static Node<Integer> addTwoLists(Node<Integer> first, Node<Integer> second) {
        Node<Integer> head1 = reverse(first);
        Node<Integer> head2 = reverse(second);
        int carry = 0;
        Node<Integer> head = null;
        Node<Integer> tail = null;

        while (head1 != null && head2 != null) {
            int sum = head1.data + head2.data + carry;
            if (sum >= 10) {
                int rem = sum % 10;
                carry = 1;
                insertAtTail(head, tail, rem);
            } else {
                insertAtTail(head, tail, sum);
                carry = 0;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            int sum = head1.data + carry;
            if (sum >= 10) {
                int rem = sum % 10;
                carry = 1;
                insertAtTail(head, tail, rem);
            } else {
                insertAtTail(head, tail, sum);
                carry = 0;
            }
            head1 = head1.next;
        }

        while (head2 != null) {
            int sum = head2.data + carry;
            if (sum >= 10) {
                int rem = sum % 10;
                carry = 1;
                insertAtTail(head, tail, rem);
            } else {
                insertAtTail(head, tail, sum);
                carry = 0;
            }
            head2 = head2.next;
        }

        if (carry == 1) {
            insertAtTail(head, tail, 1);
        }

        Node<Integer> ans = reverse(head);
        return ans;
    }

    public static void main(String[] args) {
        // Example usage

        // Creating two linked lists
        Node<Integer> first = new Node<>(2);
        first.next = new Node<>(4);
        first.next.next = new Node<>(3);

        Node<Integer> second = new Node<>(5);
        second.next = new Node<>(6);
        second.next.next = new Node<>(4);

        // Adding the two lists
        Node<Integer> result = addTwoLists(first, second);

        // Printing the result
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}

