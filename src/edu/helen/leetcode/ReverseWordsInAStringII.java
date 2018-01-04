package edu.helen.leetcode;

import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * <p>
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Could you do it in-place without allocating extra space?
 * <p>
 * Created by Helen on 12/21/2017.
 */
public class ReverseWordsInAStringII {

    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        //reverse each word
        int left=0;
        for (int i = 0; i <=s.length; i++) { // note this i < = s.length, just for the last word
            if (i == s.length || s[i] == ' ') { //Note i==s.length
                reverse(s,left,i-1);
                left = i+1;
            }
        }
        // reverse the whole string
        reverse(s,0,s.length-1);
    }
    private void reverse(char[] s,int left,int right){
        while(left<right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAStringII rw = new ReverseWordsInAStringII();
        char[] s = "the sky is blue".toCharArray();
        rw.reverseWords(s);
        System.out.printf(Arrays.toString(s));
    }
}
