package com.helen.leetcode;

import java.util.Stack;

/**
 * Created by Helen on 9/17/2017.
 */
public class AddTwoNumberII {

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode old = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int val1 = s1.isEmpty() ? 0 : s1.pop().val;
            int val2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = val1 + val2 + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            head.next = node;
            node.next = old;
            //      head = head.next;
            old = node;
        }
        if(carry!=0){
            ListNode node = new ListNode(1);
            head.next = node;
            node.next = old;
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> p = new Stack<>();
        Stack<Integer> q = new Stack<>();

        while (l1 != null) {
            p.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            q.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode curr = new ListNode(0);
        while (!p.empty() || !q.empty()) {
            int x = (!p.empty()) ? p.pop() : 0;
            int y = (!q.empty()) ? q.pop() : 0;
            sum = sum + x + y;
            curr.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = curr;
            curr = head;
            sum = sum / 10;
        }
        return curr.val == 0 ? curr.next : curr;
    }

}
