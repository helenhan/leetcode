package edu.helen.leetcode;

import java.util.List;

/**
 * 一个DP问题
 * possible[i] = true      if  S[0,i)在dictionary里面
 * <p>
 * possible[i] = true      if  possible[k] == true 并且 S[k+1,i)在dictionary里面， 0<k<i
 * <p>
 * possible[i] = false     if  no such k exist.
 * <p>
 * Created by Helen on 9/26/2017.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true; // don't forget this, otherwise dp does not start at all.
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) { // subString does not include endIndex, here is i
                    f[i] = true; //that's why f is initialed with s.length+1. f[i] is true if s[0,i-1] in dictionary.
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
