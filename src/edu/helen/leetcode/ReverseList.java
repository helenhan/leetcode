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
