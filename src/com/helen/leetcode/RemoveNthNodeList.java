package com.helen.leetcode;

public class RemoveNthNodeList {
    /**
     * A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward,
     * to maintain a gap of n between the two pointers and then move both at the same speed. Finally,
     * when the fast pointer reaches the end, the slow pointer will be n+1 places behind - just the right spot for it to be able to skip the next node.
     * Since the question gives that n is valid, not too many checks have to be put in place. Otherwise, this would be necessary.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curr = head;
        pre.next = head;
        //Move curr in front so that the gap between slow and fast becomes n
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        //Move curr to the end, maintaining the gap
        while (curr != null) {
            pre = pre.next;
            curr = curr.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        int k = size - n;
        ListNode prev = null;
        p = head;
        while (k > 0 && p != null) {
            prev = p;
            p = p.next;
            k--;
        }
        if (p != null) {
            if (prev != null) {
                prev.next = p.next;
            } else {
                return head.next;
            }
        }
        return head;
    }

}
