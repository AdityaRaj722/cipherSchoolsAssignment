package StackAndQueue.L21;

import java.util.*;

public class StackOperationsAndLRUCache {

    // Question 1: Reverse a Stack
    public static void insertAtBottom(Stack<Integer> stack, int ele) {
        if (stack.isEmpty()) {
            stack.push(ele);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, ele);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }

    // Question 2: LRU Cache
    static class LRUCache {
        private final Map<Integer, ListNode> cache;
        private final DoublyLinkedList dll;
        private final int capacity;

        public LRUCache(int capacity) {
            this.cache = new HashMap<>();
            this.dll = new DoublyLinkedList();
            this.capacity = capacity;
        }

        private void moveToFirst(int key) {
            ListNode node = cache.get(key);
            dll.remove(node);
            dll.addFirst(node);
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            moveToFirst(key);
            return cache.get(key).value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                ListNode node = cache.get(key);
                node.value = value;
                moveToFirst(key);
            } else {
                if (cache.size() == capacity) {
                    int lruKey = dll.removeLast();
                    cache.remove(lruKey);
                }
                ListNode newNode = new ListNode(key, value);
                dll.addFirst(newNode);
                cache.put(key, newNode);
            }
        }
    }

    static class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoublyLinkedList {
        private final ListNode head;
        private final ListNode tail;

        public DoublyLinkedList() {
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(ListNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int removeLast() {
            ListNode last = tail.prev;
            remove(last);
            return last.key;
        }
    }

    public static void main(String[] args) {
        System.out.println("Seems Nice.!");
    }
}

