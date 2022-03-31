package com.helen.leetcode;

/**
 * https://leetcode.com/problems/string-compression/discuss/92559/Simple-Easy-to-Understand-Java-solution
 * two pointer and one counter
 * Created by Helen on 3/5/2018.
 */
public class StringCompression {
    public int compress(char[] chars) {
        int begin = 0, end = 0;
        while (end < chars.length) {
            char ch = chars[end];
            int count = 0;
            while (end < chars.length && chars[end] == ch) {
                end++;
                count++;
            }
            chars[begin++] = ch;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[begin++] = c;
                }
            }
        }
        return begin;
    }
}
