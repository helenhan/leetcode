package edu.helen.leetcode;

public class CycleInList {

	public CycleInList() {
		// TODO Auto-generated constructor stub
	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;

	}

	// Given a linked list, return the node where the cycle begins. If there is
	// no cycle, return null.
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

}
