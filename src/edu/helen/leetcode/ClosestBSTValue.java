package edu.helen.leetcode;

/**
 * Created by Helen on 2/26/2018.
 */
public class ClosestBSTValue {

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        int a = root.val;
        TreeNode kid = target < root.val ? root.left : root.right;
        if (kid == null) return root.val;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}
