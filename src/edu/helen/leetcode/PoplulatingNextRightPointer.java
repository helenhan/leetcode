package edu.helen.leetcode;

/**
 * Created by Helen on 10/28/2017.
 */
public class PoplulatingNextRightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode levelStart = root;
        while(levelStart!=null){
            TreeLinkNode curr = levelStart;
            while(curr!=null){
                if(curr.left!=null) curr.left.next = curr.right;
                if(curr.right!=null&&curr.next!=null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }
}
