package edu.helen.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 通过向string插入"("和")"直到两者的数量都为n，则一个combination构建完成。如何保证这个combination是well-formed？在插入过程中的任何时候：

 1. 只要"("的数量没有超过n，都可以插入"("。
 2. 而可以插入")"的前提则是当前的"("数量必须要多余当前的")"数量。

 https://discuss.leetcode.com/topic/23229/java-dfs-way-solution/2

 * Created by Helen on 10/26/2017.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        if(n>0){
            helper("",n,n,result);
        }
        return result;
    }

    public void helper(String prefix,int left,int right,List<String> list){
        if(left==0&&right==0){
            list.add(prefix);
        }
        if(left>0){
            helper(prefix+"(",left-1,right,list);
        }
        if(right>left){
            helper(prefix+")",left,right-1,list);
        }
    }
}
