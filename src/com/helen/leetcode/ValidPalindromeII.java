package com.helen.leetcode;

/**
 * Created by Helen on 2/17/2018.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int cnt = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (left < right && (isValid(s, left + 1, right) || isValid(s, left, right - 1))) {
                    return true;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
