package com.helen.leetcode;

/**
 * https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 * Created by Helen on 10/21/2017.
 */
public class MinWindowSubString {
   //tmplate
    //One thing needs to be mentioned is that when asked to find maximum substring, we should update maximum
    // after the inner while loop to guarantee that the substring is valid. On the other hand, when asked to
    // find minimum substring, we should update minimum inside the inner while loop.

//    int findSubstring(String s){
//        vector<int> map(128,0);
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one point to tail and one  head
//        int d; //the length of substring
//
//        for() { /* initialize the hash map here */ }
//
//        while(end<s.length()){
//
//            if(map[s[end++]]-- ?){  /* modify counter here */ }
//
//            while(/* counter condition */){
//
//                 /* update d here if finding minimum*/
//
//                //increase begin to make it invalid/valid again
//
//                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//            }
//
//            /* update d here if finding maximum*/
//        }
//        return d;
//    }

    public String minWindow(String s, String t) {
        if(s==null||t==null||s.length()==0||t.length()==0||s.length()<t.length()){
            return "";
        }
        int[] map = new int[256];
        for(char ch:t.toCharArray()){
            map[ch]++;
        }
        int begin =0, end=0, count=t.length(),minStart=0,minLen=Integer.MAX_VALUE;
        while(end<s.length()){
            if(map[s.charAt(end++)]-->0){
                count--;
            }
            while(count==0){
                if(end-begin<minLen){
                    minStart = begin;
                    minLen = end - begin;
                }
                if(map[s.charAt(begin++)]++==0){
                    count++;
                }
            }

        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }

    /**
     * The code of solving Longest Substring with At Most Two Distinct Characters
     */
    int lengthOfLongestSubstringTwoDistinct(String s){
        int begin=0,end=0,count=0,d=0;
        int[] map = new int[256];
        while(end<s.length()){
            if(map[s.charAt(end++)]++==0){
                count++;
            }
            while(count>2){
                if(map[s.charAt(begin++)]--==1) count--;
            }
             d= Math.max(d,end-begin);
        }
        return d;
    }

    /**
     * The code of solving Longest Substring Without Repeating Characters is below:
     */
    int lengthOfLongestSubstring(String s) {
        int begin=0,end=0,count=0,d=0;
        int[] map = new int[256];
        while(end<s.length()){
            if(map[s.charAt(end++)]++>0) count++;
            while(count>0){
                if(map[s.charAt(begin++)]-->1)count--;
            }
            d = Math.max(d,end-begin);
        }
        return d;
    }

    public static void main(String[] args) {
        MinWindowSubString mw = new MinWindowSubString();
//        mw.minWindow("ADOBECODEBANC","ABC");
        mw.lengthOfLongestSubstringTwoDistinct("abbacd");
    }
}
