package edu.helen.leetcode;

public class RemoveDupFromList {

	public RemoveDupFromList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode prev = head;
		int temp = head.val;
		while (prev.next != null) {
			if (prev.next.val == temp) {
				prev.next = prev.next.next;

			} else {
				temp = prev.next.val;
				prev = prev.next;
			}
		}
		return head;
	}

	public ListNode deleteDuplicates2(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		for (ListNode node = head, prev = null; node != null; prev = node, node = node.next) {
			if ((prev == null || prev.val != node.val)
					&& (node.next == null || node.val != node.next.val)) {
				tail.next = node;
				tail = node;
			}
		}
		tail.next = null;
		return dummy.next;

	}

}
