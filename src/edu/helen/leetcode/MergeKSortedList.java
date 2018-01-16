package edu.helen.leetcode;

import java.util.PriorityQueue;

/**
 * We just use PriorityQueue to sort K nodes in list. After we poll a node and add this node in the result list,
 * we offer the next node of this node in PriorityQueue.
 * Time complexity : O(Nlogk) where k is the number of linked lists.
 The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1) time.
 There are N nodes in the final linked list.

 Space complexity :
 O(n) Creating a new linked list costs O(n) space.
 O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps) costs O(k) space (it's far less than N in most situations).

 * Created by Helen on 12/2/2017.
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) { //remember to null value
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            node = node.next;
            if (node != null) {
                queue.offer(node); // must be node not node.next otherwise throw nullpointexception
            }
        }
        tail.next = null; //do not forget to set tail.next = null
        return dummy.next;
    }
}
