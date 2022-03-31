package com.helen.leetcode;

/**
 * Created by Helen on 10/19/2017.
 */
public class FirstUniqCharInString {
    public int firstUniqChar(String s) {
        int[] array = new int[256];
        for(int i=0;i<s.length();i++){
            array[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(array[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
