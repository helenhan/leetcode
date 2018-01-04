package edu.helen.leetcode;

public class PalindromeList {

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow!= null) { // not need check fast and slow both, since they are the same length
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;

        }
        return true;

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
}
