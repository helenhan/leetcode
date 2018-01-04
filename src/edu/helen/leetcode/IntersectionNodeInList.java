package edu.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/28067/java-solution-without-knowing-the-difference-in-len
 * We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of
 * another linkedlist after it reaches the tail node. In the second iteration, we will move two pointers until they points to
 * the same node. Our operations in first iteration will help us counteract the difference. So if two linkedlist intersects,
 * the meeting point in second iteration must be the intersection point.
 * If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null
 */
public class IntersectionNodeInList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a==null?headB: a.next;
            b= b==null?headA:b.next;
        }
        return a;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode iterA = headA, iterB = headB;
        while (iterA.next != null) {
            iterA = iterA.next;
            lenA++;
        }
        while (iterB.next != null) {
            iterB = iterB.next;
            lenB++;
        }
        if (iterA != iterB) {
            return null;
        }
        iterA = headA;
        iterB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                iterA = iterA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                iterB = iterB.next;
            }
        }
        while (iterA != iterB) {
            iterA = iterA.next;
            iterB = iterB.next;
        }
        return iterA;

    }


}
