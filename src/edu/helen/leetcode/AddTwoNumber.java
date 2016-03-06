package edu.helen.leetcode;

public class AddTwoNumber {

	public AddTwoNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null||l2==null){
			return null;
		}
		ListNode result = null;
		int carry = 0;
		while(l1.next!=null&&l2.next!=null){
			ListNode node = new ListNode();
			int temp = l1.val + l2.val+carry;
		}
		
		return result;
		
	}

}
