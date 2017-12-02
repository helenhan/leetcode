package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/64434/shortest-concise-java-o-n-sliding-window-solution
 * Created by Helen on 10/21/2017.
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s==null||s.length()<p.length()){
            return list;
        }
        int[] map = new int[256];
        int begin=0,end=0,count = p.length();
        for(char c:p.toCharArray()){
            map[c]++;
        }
        while(end<s.length()){
             if(map[s.charAt(end++)]-->=1){
                 count--;
             }
            if(count==0){
                list.add(begin);
            }
            if((end-begin)==p.length()){
                if(map[s.charAt(begin++)]++>=0){
                    count++;
                }
            }
        }
        return list;
    }
}
