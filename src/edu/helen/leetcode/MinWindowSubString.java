package edu.helen.leetcode;

/**
 * Created by Helen on 10/21/2017.
 */
public class MinWindowSubString {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) return "";
        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int right = 0, left = 0, count = t.length(), minlen = Integer.MIN_VALUE, minStart = 0;
        while (left < s.length()) {
            if (map[s.charAt(left++)]-- >= 1) {
                count--;
            }
            while (count == 0) {
                if (right - left < minlen) {
                    minStart = left;
                    minlen = left - right;
                }
                if (map[s.charAt(left++)]++ >= 0) {
                    count++;
                }
            }
        }
        return minlen == Integer.MIN_VALUE ? "" : s.substring(minStart, minStart + minlen);
    }
}
