package edu.helen.leetcode;

import java.util.Stack;

/**
 * Created by Helen on 9/17/2017.
 */
public class AddTwoNumberII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> p = new Stack<>();
        Stack<Integer> q = new Stack<>();

        while (l1!=null){
            p.push(l1.val);
            l1 = l1.next;
        }

        while (l2!=null){
            q.push(l2.val);
            l2=l2.next;
        }
        int sum = 0;
        ListNode curr = new ListNode(0);
        while(!p.empty()||!q.empty()){
            int x = (!p.empty())? p.pop():0;
            int y = (!q.empty())?q.pop():0;
            sum = sum + x + y ;
            curr.val = sum %10;
            ListNode head = new ListNode(sum/10);
            head.next = curr;
            curr = head;
            sum = sum/10;
        }
        return curr.val==0?curr.next:curr;
    }
}
