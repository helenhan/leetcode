package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Helen on 10/22/2017.
 */
public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split("!");
        List<String> queue = new LinkedList<>();
        for (String str : strings) {
            queue.add(str);
        }
        return getNode((LinkedList<String>) queue);
    }

    private TreeNode getNode(LinkedList<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = getNode(queue);
        node.right = getNode(queue);
        return node;
    }

}
