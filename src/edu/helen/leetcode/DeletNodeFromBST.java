package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution
 * Steps:

 Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
 Once the node is found, have to handle the below 4 cases
 node doesn’t have left or right - return null
 node only has left subtree- return the left subtree
 node only has right subtree- return the right subtree
 node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree

 * Created by Helen on 2/25/2018.
 */
public class DeletNodeFromBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode tmp = findMin(root.right);
                root.val = tmp.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;

    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
