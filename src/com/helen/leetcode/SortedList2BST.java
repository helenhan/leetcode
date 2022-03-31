package com.helen.leetcode;

public class SortedList2BST {

	public SortedList2BST() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		return build(head, null);
	}

	public TreeNode build(ListNode head, ListNode tail) {
		if (head == tail) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		int rootVal = slow.val;
		TreeNode root = new TreeNode(rootVal);
		root.left = build(head, slow);
		root.right = build(slow.next, tail);
		return root;
	}

}
