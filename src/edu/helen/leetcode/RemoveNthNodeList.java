package edu.helen.leetcode;

public class RemoveNthNodeList {

	public RemoveNthNodeList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode p = head;
		int size = 0;
		while (p != null) {
			size++;
			p= p.next;
		}
		int k = size - n;
		ListNode prev= null;
		p = head;
		while (k > 0 && p!=null) {
			prev = p;
			p = p.next;
			k--;
		}
		if(p!=null){
			if(prev!=null){
				prev.next = p.next;
			}else{
				return head.next;
			}
		}
		return head;
	}

}
