package edu.helen.leetcode;

/**
 * http://www.cnblogs.com/grandyang/p/4290148.html
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37811/Simple-solution-using-constant-space
 * Created by Helen on 2/22/2018.
 */
public class PopulatingNextRightPointersII {

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        while (root != null) {
            TreeLinkNode tmp = new TreeLinkNode(0);
            TreeLinkNode curr = tmp;
            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                root = root.next;
            }
            root = tmp.next;
        }
    }
}
