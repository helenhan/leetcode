package com.helen.leetcode;

/**
 * 606
 * Created by Helen on 11/22/2017.
 */
public class ConstructStringFromBT {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String value = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.equals("") && right.equals("")) {
            return value;
        } else if (left.equals("")) {
            return value + "()" + "(" + right + ")";
        } else if (right.equals("")) {
            return value + "(" + left + ")";
        } else {
            return value + "(" + left + ")" + "(" + right + ")";
        }
    }
}
