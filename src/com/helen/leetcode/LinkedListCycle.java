package com.helen.leetcode;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) { // Notice the loop condition
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;

	}

}
