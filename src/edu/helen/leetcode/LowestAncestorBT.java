package edu.helen.leetcode;

/**
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * <p>
 * just use example to think algorithm
 */
public class LowestAncestorBT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { // like 5 and 1, the lca is 3. look example above.
            return root;
        } else {
            return left != null ? left : right; //if p,q are one the same side,like left,then right should be return null;
                                                //because the leaf node's children nodes are null (root==null)
        }
    }
}
