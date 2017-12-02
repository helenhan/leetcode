package edu.helen.leetcode;

import java.util.List;

public class AddTwoNumber {

    public AddTwoNumber() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q=l2,curr = head;
        int carry = 0;
        while(p!=null|| q!=null){
            int value1 = (p!=null)? p.val:0;
            int value2 =(q!=null)?q.val:0;
            int sum = value1 + value2 + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p!=null)p=p.next;
            if(q!=null)q=q.next;
        }
        if(carry>0){
            ListNode tail = new ListNode(carry);
            curr.next = tail;
        }
        return head.next;
    }

}
