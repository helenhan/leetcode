package edu.helen.leetcode;

/**
 * Created by Helen on 10/28/2017.
 */
public class PoplulatingNextRightPointer {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        TreeLinkNode curr = root;
        TreeLinkNode leftMost = null;
        while(curr.left!=null){
            leftMost = curr.left;
            while(curr!=null){
                curr.left.next = curr.right;
                curr.right.next = curr.next==null?null:curr.next.left;
                curr = curr.next;
            }
            curr = leftMost;
        }
    }
}
