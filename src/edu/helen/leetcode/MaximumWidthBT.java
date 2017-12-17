package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/100145/java-c-very-simple-dfs-solution/7
 *
 * We know that a binary tree can be represented by an array (assume the root begins from the position with index 1 in the array).
 * If the index of a node is i, the indices of its two children are 2*i and 2*i + 1. The idea is to use two arrays (start[] and end[])
 * to record the the indices of the leftmost node and rightmost node in each level, respectively.
 * For each level of the tree, the width is end[level] - start[level] + 1. Then, we just need to find the maximum width.
 *
 * Created by Helen on 11/24/2017.
 */
public class MaximumWidthBT {
    int max = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        help(root, 0, 1, list);
        return max;
    }

    public void help(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(index);
        }
        max = Math.max(max, index - list.get(level) + 1); //the index at this moment is the index of every node in this level.
        help(root.left, level + 1, 2 * index, list);
        help(root.right, level + 1, 2 * index + 1, list);
    }
}
