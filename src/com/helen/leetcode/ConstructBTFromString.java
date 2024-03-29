package com.helen.leetcode;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
 * The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 * You always start to construct the left child node of the parent first if it exists.
 * Example:
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * Note:
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 * <p>
 * https://discuss.leetcode.com/topic/82572/java-recursive-solution/2
 * http://www.cnblogs.com/grandyang/p/6793904.html
 * 这道题让我们根据一个字符串来创建一个二叉树，其中结点与其左右子树是用括号隔开，每个括号中又是数字后面的跟括号的模式，
 * 这种模型就很有递归的感觉，所以我们当然可以使用递归来做。首先我们要做的是先找出根结点值，我们找第一个左括号的位置，如果找不到，
 * 说明当前字符串都是数字，直接转化为整型，然后新建结点返回即可。否则的话从当前位置开始遍历，因为当前位置是一个左括号，
 * 我们的目标是找到与之对应的右括号的位置，但是由于中间还会遇到左右括号，所以我们需要用一个变量cnt来记录左括号的个数，
 * 如果遇到左括号，cnt自增1，如果遇到右括号，cnt自减1，这样当某个时刻cnt为0的时候，我们就确定了一个完整的子树的位置，
 * 那么问题来了，这个子树到底是左子树还是右子树呢，我们需要一个辅助变量start，当最开始找到第一个左括号的位置时，
 * 将start赋值为该位置，那么当cnt为0时，如果start还是原来的位置，说明这个是左子树，我们对其调用递归函数，注意此时更新start的位置，这样就能区分左右子树了
 * Created by Helen on 12/14/2017.
 */
public class ConstructBTFromString {

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int first = s.indexOf("(");
        int val = first == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, first));
        TreeNode root = new TreeNode(val);
        if (first == -1) { // do not forget this step
            return root;
        }
        int start = first;
        int leftcnt = 0;
        for (int i = start; i < s.length(); i++) { //i is from start not 0
            if (s.charAt(i) == '(') {
                leftcnt++;
            } else if (s.charAt(i) == ')') {
                leftcnt--;
            }
            if (leftcnt == 0 && start == first) {
                root.left = str2tree(s.substring(start + 1, i)); // don't forget assign result to root.left
                start = i + 1; // don't forget change start
            } else if (leftcnt == 0) {
                root.right = str2tree(s.substring(start + 1, i));
            }
        }
        return root;
    }
}
