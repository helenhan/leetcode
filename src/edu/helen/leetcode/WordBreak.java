package edu.helen.leetcode;

import java.util.List;

/**
 *
 *  possible[i] = true      if  S[0,i]在dictionary里面

 = true      if   possible[k] == true 并且 S[k+1,j]在dictionary里面， 0<k<i

 = false      if    no such k exist.

 * Created by Helen on 9/26/2017.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0;j<i;j++){
                if(f[j] && wordDict.contains(s.substring(j,i))){
                    f[i]=true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
