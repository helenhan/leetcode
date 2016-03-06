package edu.helen.leetcode;

public class IntersectionNodeInList {

	public IntersectionNodeInList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA==headB||headA == null || headB == null) {
			return headA == null ? headA : headB;
		}
		ListNode result = null;
		int aLength = getLength(headA);
		int bLength = getLength(headB);

		ListNode p1 = aLength >= bLength ? headA : headB;
		ListNode p2 = aLength < bLength ? headA : headB;
		int gap = Math.abs(aLength - bLength);
		while (gap > 0) {
			p1 = p1.next;
			gap--;
		}
		while (p1 != null) {
			if (p1 == p2) {
				result = p1;
				break;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return result;

	}

	private int getLength(ListNode head) {
		int size = 0;
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}

}
