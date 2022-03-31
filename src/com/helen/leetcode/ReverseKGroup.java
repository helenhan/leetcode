package com.helen.leetcode;

/**
 * https://stomachache007.wordpress.com/2017/04/05/title4/#more-891
 * Created by Helen on 12/16/2017.
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (true) {
            head = reverse(head, k);
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }

    //head->n1->n2->...->nk->nk+1
    //=>
    //head->nk->nk-1->..->n2->n1->nk+1
    //return n1;
    private ListNode reverse(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        if (nk == null) {
            return null;
        }
        //reverse
        ListNode n1 = head.next;
        ListNode nkplus = nk.next;
        ListNode cur = n1, prev = null;
        while (cur != nkplus) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        //connect
        head.next = nk;
        n1.next = nkplus;
        return n1;

    }
}
