package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://discuss.leetcode.com/topic/77775/verbose-java-solution-postorder-traverse-hashmap-18ms
 * Idea is post-order traverse the tree and get sum of every sub-tree, put sum to count mapping to a HashMap.
 * Then generate result based on the HashMap.
 * Created by Helen on 11/9/2017.
 */
public class MostFrequentSubtreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    int maxcount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        postOrder(root);
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxcount) {
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode root) {  // must be post-order since only after we know both subtrees' sum, then we can get sum of the root node.
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int sum = left + right + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        maxcount = Math.max(maxcount, count);
        return sum;
    }



}
