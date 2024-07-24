package LinkedList.L15;

public class addNumberLL {

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
        public ListNode addTwoNumbers(ListNode a, ListNode b) {
            if (a == null) {
                return b;
            } else if (b == null) {
                return a;
            } else {
                ListNode dummy = new ListNode(0);
                ListNode p = a, q = b, r = dummy;
                int sum = 0, carry = 0;

                while (p != null || q != null) {
                    sum = (p == null ? 0 : p.val) + (q == null ? 0 : q.val) + carry;
                    carry = sum / 10;
                    sum = sum % 10;
                    r.next = new ListNode(sum);
                    r = r.next;

                    if (p != null) p = p.next;
                    if (q != null) q = q.next;
                }

                if (carry > 0) {
                    r.next = new ListNode(carry);
                }

                return dummy.next;
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 342
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 465

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

