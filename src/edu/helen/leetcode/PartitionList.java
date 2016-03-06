package edu.helen.leetcode;

public class PartitionList {

	public PartitionList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode head1 = dummy1;
		ListNode head2 = dummy2;
		// dummy1.next = head;
		while (head != null) {
			ListNode tmp = head.next;//necessary??
			if (head.val < x) {
				head1.next = head;
				head1 = head;
			} else {
				head2.next = head;
				head2 = head;
				head2.next = null;//important
			}
			head = tmp;
		}
		head1.next = dummy2.next;
		return dummy1.next;
	}
}
