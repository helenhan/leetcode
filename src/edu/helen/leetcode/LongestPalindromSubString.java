package edu.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/23498/very-simple-clean-java-solution
 * worst case performance of O(n^2) and O(n*len) on average.
 * Created by Helen on 9/17/2017.
 */
public class LongestPalindromSubString {
    int lo = 0, maxlen = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            extendFromCenter(s, i, i); //odd
            extendFromCenter(s, i, i + 1);//even
        }
        return s.substring(lo, lo + maxlen);
    }

    private void extendFromCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++; //remember we extend from i, not from two ends
        }
        if (maxlen < r - l - 1) {
            lo = l + 1;
            maxlen = r - l - 1; // we add one more time in above while loop for l and r; 因为是l和r是加减完了才判断是不是符合条件，当不符合条件的时候已经加减完了
        }
    }

    //my solution, brutal forces time limit exceed O(n^3)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i = 0;
        int max = 0;
        String res = "";
        while (i < s.length()) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrom(s, i, j)) {
                    int length = j - i + 1;
                    if (length > max) {
                        max = length;
                        res = s.substring(i, j + 1);
                    }
                }
            }
            i++;
        }
        return res;
    }

    private boolean isPalindrom(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
