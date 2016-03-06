package edu.helen.leetcode;

public class OddEvenList {

	public OddEvenList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode oddEvenList(ListNode head) {
        
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode first = dummy1;
		ListNode second = dummy2;
		int count = 1;
		while (head != null) {
			ListNode temp = head.next;
			if ((count % 2) != 0) {
				first.next = head;
				first = head;
			} else {
				second.next = head;
				second = head;
				second.next = null;//important
			}
			count++;
			head = temp;
		}
		first.next = dummy2.next;
		return dummy1.next;
	
    }
}
