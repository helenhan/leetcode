package edu.helen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Helen on 9/25/2017.
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head,next = head;
        while(iter!=null){
            RandomListNode copy = new RandomListNode(iter.label);
            next = iter.next;
            copy.next = next;
            iter.next = copy;
            iter = next;
        }

         iter=head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random = iter.random.next; //don't understand why it is iter.random.next not iter.random???
            }
            iter = iter.next.next;
        }

        iter=head;
        RandomListNode psudoHead = new RandomListNode(0);
        RandomListNode copy,copyIter = psudoHead;
        while(iter!=null){
            next = iter.next.next;

            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            iter.next = next;
            iter = next;
        }
        return psudoHead.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while(node!=null){
            map.put(node,new RandomListNode(node.label));
            node = node.next;
        }
        RandomListNode iter = head;
        while(iter!=null){
            map.get(iter).next = map.get(iter.next);
            map.get(iter).random = map.get(iter.random);
            iter = iter.next;
        }
        return map.get(head);
    }
}
