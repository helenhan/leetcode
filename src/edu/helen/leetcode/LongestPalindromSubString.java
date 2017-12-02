package edu.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/23498/very-simple-clean-java-solution
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
            r++;
        }
        if (maxlen < r - l - 1) {
            lo = l + 1;
            maxlen = r - l - 1; // we add one more time in above while loop for l and r; 因为是l和r是加减完了才判断是不是符合条件，当不符合条件的时候已经加减完了
        }
    }

}
