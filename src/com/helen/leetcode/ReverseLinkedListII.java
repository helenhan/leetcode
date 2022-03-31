package com.helen.leetcode;

/**
 * Created by Helen on 1/26/2018.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode curr = new ListNode(0);
        curr.next = head;
        int k = n - m;
        int j = m;
        while (j > 1) {
            curr = curr.next;
            j--;
        }
        ListNode reve = curr.next;
        while (k > 0) {
            ListNode temp = reve.next;
            reve.next = reve.next.next;
            temp.next = curr.next;
            curr.next = temp;
            k--;
        }
        if (m == 1) {
            head = curr.next;
        }
        return head;

    }
}
