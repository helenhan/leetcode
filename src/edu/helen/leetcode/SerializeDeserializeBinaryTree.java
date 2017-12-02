package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Helen on 10/15/2017.
 */
public class SerializeDeserializeBinaryTree {
    private static final String NN = "X";
    private static final String delimiter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildString(root,builder);
        return builder.toString();
    }

    private void buildString(TreeNode node,StringBuilder builder){
        if(node==null){
            builder.append(NN).append(delimiter);
        }else{
            builder.append(node.val).append(delimiter);
            buildString(node.left,builder);
            buildString(node.right,builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(delimiter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if(val.equals(NN)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
