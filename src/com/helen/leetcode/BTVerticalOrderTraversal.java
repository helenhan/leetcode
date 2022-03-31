package com.helen.leetcode;

import java.util.*;

/**
 * 这道题让我们竖直遍历二叉树，并把每一列存入一个二维数组，我们看题目中给的第一个例子，3和15属于同一列，3在前，
 * 第二个例子中，3,5,2在同一列，3在前，5和2紧随其后，那么我们隐约的可以感觉到好像是一种层序遍历的前后顺序，
 * 那么我们如何来确定列的顺序呢，我们可以把根节点给个序号0，然后开始层序遍历，凡是左子节点则序号减1，右子节点序号加1，
 * 这样我们可以通过序号来把相同列的节点值放到一起，我们用一个map来建立序号和其对应的节点值的映射，
 * 用map的另一个好处是其自动排序功能可以让我们的列从左到右，由于层序遍历需要用到queue，我们此时queue里不能只存节点，
 * 而是要存序号和节点组成的pair，这样我们每次取出就可以操作序号，而且排入队中的节点也赋上其正确的序号
 *
 * The following solution takes 5ms.

 BFS, put node, col into queue at the same time
 Every left child access col - 1 while right child col + 1
 This maps node into different col buckets
 Get col boundary min and max on the fly
 Retrieve result from cols
 Note that TreeMap version takes 9ms.

 https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/76401/5ms-Java-Clean-Solution

 * Created by Helen on 2/27/2018.
 */
public class BTVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        queue.offer(new Pair(0,root));
        while(!queue.isEmpty()){


            Pair pair = queue.poll();
            if(!map.containsKey(pair.index)){
                map.put(pair.index,new ArrayList<>());
            }
            map.get(pair.index).add(pair.node.val);

            if(pair.node.left!=null){
                queue.offer(new Pair(pair.index-1,pair.node.left));
            }
            if(pair.node.right!=null){
                queue.offer(new Pair(pair.index+1,pair.node.right));
            }

        }
        for(int key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    class Pair{
        TreeNode node;
        int index;
        Pair(int index, TreeNode node){
            this.index = index;
            this.node = node;
        }
    }
}
