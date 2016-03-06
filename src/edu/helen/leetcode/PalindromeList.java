package edu.helen.leetcode;

public class PalindromeList {

	public PalindromeList() {
		// TODO Auto-generated constructor stub
	}

	 public boolean isPalindrome(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;
		
			while(fast!=null&&fast.next!=null){
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode head2 =  reverse(slow);
			while(head2!=null){
				if(head.val!=head2.val){
					return false;
				}
				head = head.next;
				head2 = head2.next;
			}
			return true;

		}

		private ListNode reverse(ListNode head) {
			ListNode pre = null;
			ListNode curr = head;
			while (curr != null) {
				ListNode temp = curr.next;
				curr.next = pre;
				pre = curr;
				curr = temp;
			}
			return pre;
		}
}
