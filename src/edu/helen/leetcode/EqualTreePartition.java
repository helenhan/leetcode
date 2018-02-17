package edu.helen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees
 * which have the equal sum of values after removing exactly one edge on the original tree.
 * Example 1:
 * Input:
 * 5
 * / \
 * 10 10
 * /  \
 * 2   3
 * <p>
 * Output: True
 * Explanation:
 * 5
 * /
 * 10
 * <p>
 * Sum: 15
 * <p>
 * 10
 * /  \
 * 2    3
 * <p>
 * Sum: 15
 * <p>
 * Example 2:
 * Input:
 * 1
 * / \
 * 2  10
 * /  \
 * 2   20
 * <p>
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 * https://discuss.leetcode.com/topic/100179/java-c-simple-solution-with-only-one-hashmap
 * http://www.cnblogs.com/grandyang/p/7550360.html
 * 这道题让我们划分等价树，就是说当移除一条边后，被分成的两棵树的结点之和需要相等。那么通过观察题目中的例子我们可以发现，
 * 如果我们将每个结点的结点值变成其所有子结点的结点值之和再加上当前的结点值，那么对于例子1来说，根结点的结点值就变成了30，
 * 断开位置的结点就变成了15，那么我们就可以发现其实只要断开位置的结点值是根结点值的一半，就存在等价划分。
 * 所以这道题的难点就是更新每个结点的结点值，我们可以使用递归来做。博主最开始使用的是unordered_set，把更新后的每个结点值都存入集合中，
 * 但是对于test case: [0, 1, -1] 会fail, 仔细分析下这个case，发现更新后的根结点值还是0，而且0已经被存入集合了，而0除以2还是0，
 * 在集合中存在，会返回true，但其实这棵树是不能等价划分的。
 * 0的情况确实比较特殊，所以我们使用unordered_map，建立更新后的结点值和其出现次数之间的映射，这样只有map中0的个数大于1的时候，才返回true。这样完美的避开了根结点为0的陷阱，Perfect！
 * Created by Helen on 11/24/2017.
 */
public class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = sum(root, map);
        if (sum == 0) {
            if (map.get(0) > 1) {
                return true;
            } else {
                return false;
            }
        }
        if (sum % 2 == 0 && map.containsKey(sum / 2)) {
            return true;
        } else {
            return false;
        }
    }

    private int sum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int value = root.val + sum(root.left, map) + sum(root.right, map);
        map.put(value, map.getOrDefault(value, 0) + 1);
        return value;
    }


    public static void main(String[] args) {

    }
}
