package edu.helen.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedList {

	public MergeSortedList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				ListNode temp = l1.next;
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

	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<>(
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						return a.val - b.val;
					}

				});
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		for (ListNode node : lists) {
			if (node != null) {
				heap.offer(node);
			}
		}
		while (heap.size() > 0) {
			ListNode p = heap.poll();
			tail.next = p;
			tail = p;
			p = p.next;
			if (p != null) {
				heap.offer(p);
			}
		}
		tail.next = null;
		return dummy.next;
	}
}
