package edu.helen.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class MergeSortedList {

	//Notice the new list should be made by splicing together the nodes of the first two lists.
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				ListNode temp = l1.next; //store l1.next otherwise we lose l1's pointer.
				tail.next = l1;
				tail = l1;
				l1 = temp;
			} else {
				ListNode temp = l2.next;
				tail.next = l2;
				tail = l2;
				l2 = temp;
			}
		}
		ListNode con = l1 == null ? l2 : l1;
		if (con != null) {
			tail.next = con;
		}
		return dummy.next;
	}



}
