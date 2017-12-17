package edu.helen.leetcode;

import java.util.PriorityQueue;

/**
 * We just use PriorityQueue to sort K nodes in list. After we poll a node and add this node in the result list, we offer the next node of this node in PriorityQueue.
 * Created by Helen on 12/2/2017.
 */
public class MergeKSortedList {
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists==null|| lists.length==0) return null;
        if(lists.length==1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val-b.val));
        for(ListNode node:lists){
            if(node!=null) { //remember to null value
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            node = node.next;
            if(node!=null){
                queue.offer(node);
            }
        }
        tail.next = null; //do not forget to set tail.next = null
        return dummy.next;
    }
}
