package com.helen.leetcode;

import java.util.Stack;

/**
 * Created by Helen on 2/26/2018.
 */
public class InorderSuccessor {

    // Not AC
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null|| root.val == p.val) {
            return null;
        }
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (flag) {
                return curr;
            }
            if (p == curr) {
                flag = true;
            }
            curr = curr.right;
        }
        return null;
    }

    public static void main(String[] args) {
        InorderSuccessor is = new InorderSuccessor();
        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        TreeNode p = new TreeNode(2);
        is.inorderSuccessor(root,p);
    }

    /**
     * https://leetcode.com/problems/inorder-successor-in-bst/discuss/72653/Share-my-Java-recursive-solution
     *  let’s take the successor for example, basically we always want to find p's closest node (in inorder traversal)
     *  and the node’s value is larger than p's value, right? That node can either be p's parent or the smallest node in p’ right branch.
     When the code runs into the else block, that means the current root is either p's parent or a node in p's right branch.
     If it’s p's parent node, there are two scenarios: 1. p doesn’t have right child, in this case,
     the recursion will eventually return null, so p's parent is the successor; 2. p has right child, then the recursion will return the smallest node in the right sub tree, and that will be the answer.
     If it’s p's right child, there are two scenarios: 1. the right child has left sub tree,
     eventually the smallest node from the left sub tree will be the answer; 2. the right child has no left sub tree,
     the recursion will return null, then the right child (root) is our answer.
     I guess it’s hard to understand unless you draw different scenarios out. :)
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if(root ==null){
            return null;
        }
        if(root.val<=p.val){
            return  inorderSuccessor(root.right,p);
        }else{
            TreeNode left = inorderSuccessor(root.left,p);
            return left!=null?left:root;
        }
    }
}
