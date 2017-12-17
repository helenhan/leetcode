package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/5414/dfs-with-one-linkedlist-accepted-java-solution/8
 * This is because after finishing the statements in if, we will never walk into else. So it is not necessary to use return here.
 * <p>
 * Also using ArrayList allows O(1) access to the each node, that means removing the last element takes only O(1).
 * If you use LinkedList, initially we have traverse the list to the last node then remove it, which takes O(n) time. I guess this is what @firesum is trying to suggest.
 * <p>
 * why we need to remove cur.remove(cur.size-1):
 * This is the backtracking point. If we execute two sub recursive code in else branch and still can't get a match pathSum,
 * this means the current "root" which already added into the List currentResult can not lead us to the correct answer.
 * So we need to remove it from List currentResult and try other possible branches, this is what backtracking means.
 * Created by Helen on 12/9/2017.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root,sum,cur,res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(cur));
        }else{
            helper(root.left,sum-root.val,cur,res);
            helper(root.right,sum-root.val,cur,res);
        }
        cur.remove(cur.size()-1);
    }
}
