package edu.helen.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC++-Three-simple-methods-choose-one-you-like
 * This method also works for those who are not BSTs. The idea is to use a hashtable to save the values of the nodes in the BST.
 * Each time when we insert the value of a new node into the hashtable, we check if the hashtable contains k - node.val.

 Time Complexity: O(n), Space Complexity: O(n).
 * Created by Helen on 2/28/2018.
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root,set,k);
    }
    private boolean helper(TreeNode root,Set<Integer> set, int k){
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return helper(root.left,set,k) || helper(root.right,set,k);
    }
}
