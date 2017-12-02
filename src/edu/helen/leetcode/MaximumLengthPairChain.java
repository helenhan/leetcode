package edu.helen.leetcode;

import java.util.Arrays;

/**
 * http://www.cnblogs.com/grandyang/p/7381633.html
 * 这道题给了我们一些链对，规定了如果后面链对的首元素大于前链对的末元素，那么这两个链对就可以链起来，问我们最大能链多少个。
 * 那么我们想，由于规定了链对的首元素一定小于尾元素，我们需要比较的是某个链表的首元素和另一个链表的尾元素之间的关系，
 * 如果整个链对数组是无序的，那么就很麻烦，所以我们需要做的是首先对链对数组进行排序，按链对的尾元素进行排序，小的放前面。这样我们就可以利用Greedy算法进行求解了。
 * 我们可以用一个栈，先将第一个链对压入栈，然后对于后面遍历到的每一个链对，我们看其首元素是否大于栈顶链对的尾元素，如果大于的话，就将当前链对压入栈，这样最后我们返回栈中元素的个数即可
 * <p>
 * <p>
 * 我们可以对上面解法的空间进行优化，并不需要用栈来记录最长链上的每一个链对。而是用一个变量end来记录当前比较到的尾元素的值，
 * 初始化为最小值，然后遍历的时候，如果当前链对的首元素大于end，那么结果res自增1，end更新为当前链对的尾元素，
 * Created by Helen on 11/23/2017.
 */
public class MaximumLengthPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int end = Integer.MIN_VALUE;
        int res =0;
        for(int[] pair:pairs){
           if( pair[0] > end){
               res++;
               end = pair[1];
           }
        }
        return res;
    }
}
