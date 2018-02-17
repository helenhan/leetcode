package edu.helen.leetcode;

/**
 * Created by Helen on 2/12/2018.
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        char[] chs = s.toCharArray();
        int left=0, right = s.length()-1;
        while(left<right){
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;

        }
        return new String(chs);
    }
}
