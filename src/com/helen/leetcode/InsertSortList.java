package com.helen.leetcode;

public class InsertSortList {

	public InsertSortList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		while (p.next != null) {
			ListNode current = p.next;
			if (current.val >= p.val) {
				p = p.next;
				continue;
			}
			p.next = current.next;
			ListNode q = dummy;
			while (q.next != null && current.val > q.next.val) {
				q = q.next;
			}
			current.next = q.next;
			q.next = current;
		}
		return dummy.next;

	}

}
