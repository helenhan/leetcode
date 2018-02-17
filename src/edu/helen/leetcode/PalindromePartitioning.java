package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://stomachache007.wordpress.com/2017/03/22/%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%E7%AC%94%E8%AE%B0-5-%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2-depth-first-search/#more-786
 * 这道题的本质是组合问题:
 * aab怎么分割的问题, 就是要不要缝隙
 * 三个字符两个空隙, 每个空隙我可以选择要或者不要, 所以有4个答案.
 * a|a|b
 * a|ab
 * aa|b
 * aab
 * 一边切, 一边验证是不是回文串
 * <p>
 * Created by Helen on 12/6/2017.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, String s, int start) {
        if (start == s.length()) { // NOTE:it's length not length-1
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    list.add(s.substring(start, i + 1));
                    helper(res, list, s, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        pp.partition("aab");
    }
}
