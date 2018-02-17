package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/solution/
 */
public class ReverseList {

    //iterative
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) { //note here is curr NOT head
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre; // return pre NOT cur because cur here is null.
    }

    //recursive
    public ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next= head;
        head.next=null; //must be null otherwise ur linkedlist has a circle in it.This bug could be caught if you test your code with a linked list of size 2.
        return p;
    }
}
