package edu.helen.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Helen on 10/14/2017.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()){
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        if(!sa.equals(ta)){
            return false;
        }else {
            return true;
        }
    }

    public boolean isAnagram2(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()){
            return false;
        }
        int[]  counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int count:counter){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}
