package com.helen.leetcode;

public class RemoveElementsFromList {

	public RemoveElementsFromList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		while (head.val == val) {
			head = head.next;
			if (head == null) {
				return head;
			}
		}
		ListNode prev = head;
		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;
			}else{
				prev = prev.next;
			}
		}
		return head;
	}

}
