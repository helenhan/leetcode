package com.helen.leetcode;

/**
 * https://stomachache007.wordpress.com/2017/04/05/title4/#more-891
 * <p>
 * 因此，当快慢指针在环中相遇时，我们再令一个慢指针从头节点出发
 * 接下来当两个慢指针相遇时，即为E所在的位置
 * <p>
 * Created by Helen on 12/16/2017.
 */
public class LinkedListCycleII {
    // Given a linked list, return the node where the cycle begins. If there is
    // no cycle, return null.
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
