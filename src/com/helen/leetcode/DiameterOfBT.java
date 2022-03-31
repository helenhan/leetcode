package com.helen.leetcode;

/**
 * 这道题让我们求二叉树的直径，并告诉了我们直径就是两点之间的最远距离，根据题目中的例子也不难理解题意。
 * 我们再来仔细观察例子中的那两个最长路径[4,2,1,3] 和 [5,2,1,3]，我们转换一种角度来看，
 * 是不是其实就是根结点1的左右两个子树的深度之和再加1呢。那么我们只要对每一个结点求出其左右子树深度之和，再加上1就可以更新结果res了。
 * https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth
 *
 * Created by Helen on 2/27/2018.
 */
public class DiameterOfBT {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxDepth( root);
        return max;
    }
    private int maxDepth(TreeNode  root){
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max,left+right);

        return Math.max(left,right)+1; //when left + right, the length would be left + right + 2????
    }
}
