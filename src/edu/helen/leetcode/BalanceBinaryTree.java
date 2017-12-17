package edu.helen.leetcode;

public class BalanceBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return helper(root, 0) >= 0;

    }

    public int helper(TreeNode p, int hight) {
        if (p == null) { //leaf or root ==null;
            return hight;
        }
        int lefthight = helper(p.left, hight + 1);
        int righthight = helper(p.right, hight + 1);
        if (lefthight < 0 || righthight < 0 || Math.abs(lefthight - righthight) > 1) {
            return -1;
        }
        return Math.max(lefthight, righthight);

    }

}
