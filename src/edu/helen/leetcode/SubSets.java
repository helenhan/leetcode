package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 * https://stomachache007.wordpress.com/2017/03/07/414/#more-414
 * DFS即深度优先搜索，本质是回溯，是back tracking。
 * 递归三要素：接受什么参数，返回什么值，做了什么事儿
 * 这里是找到所有以subset开始的集合，然后丢到result里面
 * 四大步骤：1. add{new一个空的出来}   2.加一个数  3.调用自己的小任务   4.删这个数
 * <p>
 * –构造每个答案的时间 * 答案的个数
 * O( n * 2^n)
 * Created by Helen on 9/23/2017.
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        //deep copy but every time create a new ArrayList instance with list content in res.
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]); //[]->[1], or [1]->[1,2]
            backtrack(res, list, nums, i + 1);//for eg, find all that started with [1,2]
            list.remove(list.size() - 1); //把list.add加进来的那个数去除，因为要回到上一层了
        }
    }

    /**
     * 由于S[0: n-1]组成的每一个subset，可以看成是对是否包含S[i]的取舍。
     * S[i]只有两种状态，包含在特定subset内，或不包含。
     * 所以subset的数量总共有2^n个。所以可以用0~2^n-1的二进制来表示一个subset。
     * 二进制中每个0/1表示该位置的S[i]是否包括在当前subset中。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp.add(nums[j]);
                }
            }
            result.add(tmp);
        }
        return result;
    }


    public static void main(String[] args) {
        SubSets ss = new SubSets();
        ss.subsets(new int[]{1, 2, 3});
    }


}
