package edu.helen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://stomachache007.wordpress.com/2017/04/05/title4/#more-891
 * Created by Helen on 9/25/2017.
 */
public class CopyRandomList {
    ///*第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。
    // 然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`, 然后第二遍copy的时候去建立边的copy， 拆分节点,
    // 一边扫描一边拆成两个链表，这里用到两个dummy node。第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`  */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    private void copyNext(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            newNode.next = curr.next;
            newNode.random = curr.random;
            curr.next = newNode;
            curr = curr.next.next;
        }
    }

    private void copyRandom(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            if (curr.next.random != null) {
                curr.next.random = curr.random.next; // use an example to understand it.
            }
            curr = curr.next.next;
        }
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode tmp = curr.next;
            if(curr.next!=null) {
                curr.next = curr.next.next;
            }
            curr = tmp.next;
            if(tmp.next!=null) {
                tmp.next = tmp.next.next;
            }
        }
        return newHead;
    }


    public static void main(String[] args) {
         CopyRandomList crl = new CopyRandomList();
        RandomListNode l1 = new RandomListNode(-1);
        RandomListNode l2 = new RandomListNode(1);
    }

    //use HashMap
    public RandomListNode copyRandomList2(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        RandomListNode iter = head;
        while (iter != null) {
            map.get(iter).next = map.get(iter.next);
            map.get(iter).random = map.get(iter.random);
            iter = iter.next;
        }
        return map.get(head);
    }
}
