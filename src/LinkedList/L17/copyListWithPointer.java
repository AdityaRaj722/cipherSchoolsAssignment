package LinkedList.L17;
import java.util.HashMap;
import java.util.Map;

public class copyListWithPointer {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int _val) {
            val = _val;
            next = null;
            random = null;
        }
    }

    // Using extra space (HashMap)
    public static Node copyRandomListWithMap(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;

        // First pass: create a copy of each node
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        // Second pass: assign next and random pointers
        while (temp != null) {
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    // Using pointers only
    public static Node copyRandomList(Node head) {
        Node iter = head;

        // Step 1: Create a copy of each node and insert it after the original node
        while (iter != null) {
            Node front = iter.next;
            Node copy = new Node(iter.val);
            copy.next = front;
            iter.next = copy;
            iter = front;
        }

        // Step 2: Assign random pointers for the copied nodes
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Step 3: Separate the original list and the copied list
        iter = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while (iter != null) {
            Node front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = front;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("Nice one");
    }
}

