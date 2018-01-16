package edu.helen.leetcode;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 * 把出现过的字符都放入set中，遇到set中没有的字符就加入set中并更新结果res，如果遇到重复的，则从左边开始删字符，直到删到重复的字符停止：
 * Created by Helen on 8/4/2016.
 */
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int size = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                size = Math.max(size, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return size;
    }

    public static void main(String[] args) {
        LongestSubString lss = new LongestSubString();
        System.out.println(lss.lengthOfLongestSubstring("pwwkew"));
    }

}
