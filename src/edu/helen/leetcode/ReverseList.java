package edu.helen.leetcode;

public class ReverseList {

	public ReverseList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		if (head != null && head.next != null) {
			ListNode pivot = head;
			ListNode frontier = null;
			while (pivot != null && pivot.next != null) {
				frontier = pivot.next;
				pivot.next = pivot.next.next;
				frontier.next = head;
				head = frontier;
			}
		}
		return head;

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode curr = new ListNode(0);
		curr.next = head;
		int k = n - m;
		int j = m;
		while (j > 1) {
			curr = curr.next;
			j--;
		}
		ListNode reve = curr.next;
		while (k > 0) {
			ListNode temp = reve.next;
			reve.next = reve.next.next;
			temp.next = curr.next;
			curr.next = temp;
			k--;
		}
		if(m==1){
			head = curr.next;
		}
		return head;

	}
}
