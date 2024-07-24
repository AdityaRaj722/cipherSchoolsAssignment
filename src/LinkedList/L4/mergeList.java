package LinkedList.L4;



public class mergeList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
            this.val = 0;
            this.next = null;
        }
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(-1); // Dummy node
            ListNode tail = head;
            ListNode curr1 = list1;
            ListNode curr2 = list2;

            while (curr1 != null && curr2 != null) {
                if (curr1.val < curr2.val) {
                    tail.next = curr1;
                    tail = curr1;
                    curr1 = curr1.next;
                } else {
                    tail.next = curr2;
                    tail = curr2;
                    curr2 = curr2.next;
                }
            }

            // If any nodes left in list1
            while (curr1 != null) {
                tail.next = curr1;
                tail = curr1;
                curr1 = curr1.next;
            }

            // If any nodes left in list2
            while (curr2 != null) {
                tail.next = curr2;
                tail = curr2;
                curr2 = curr2.next;
            }

            return head.next; // Return the next of dummy node
        }
    }

    public static void main(String[] args) {
        // Example usage
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

