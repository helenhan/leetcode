package edu.helen.leetcode;

public class IntersectionNodeInList {

	public IntersectionNodeInList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null){
			return null;
		}
		int lenA =0, lenB=0;
		ListNode iterA = headA, iterB= headB;
		while(iterA.next!=null){
			iterA = iterA.next;
			lenA++;
		}
		while(iterB.next!=null){
			iterB = iterB.next;
			lenB++;
		}
		if(iterA!=iterB){
			return null;
		}
		iterA = headA;
		iterB = headB;
		if(lenA>lenB) {
			for (int i = 0; i < lenA - lenB; i++) {
				iterA = iterA.next;
			}
		}else{
			for (int i = 0; i < lenB - lenA; i++) {
				iterB = iterB.next;
			}
		}
		while(iterA!=iterB){
			iterA = iterA.next;
			iterB = iterB.next;
		}
		return iterA;

	}



}
