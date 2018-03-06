package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/wildcard-matching/discuss/17810/Linear-runtime-and-constant-space-solution
 *
 *
 // greedy solution with idea of DFS
 // starj stores the position of last * in p
 // last_match stores the position of the previous matched char in s after a *
 // e.g.
 // s: a c d s c d
 // p: * c d
 // after the first match of the *, starj = 0 and last_match = 1
 // when we come to i = 3 and j = 3, we know that the previous match of * is actually wrong,
 // (the first branch of DFS we take is wrong)
 // then it resets j = starj + 1
 // since we already know i = last_match will give us the wrong answer
 // so this time i = last_match+1 and we try to find a longer match of *
 // then after another match we have starj = 0 and last_match = 4, which is the right solution
 // since we don't know where the right match for * ends, we need to take a guess (one branch in DFS),
 // and store the information(starj and last_match) so we can always backup to the last correct place and take another guess.

 * Created by Helen on 2/25/2018.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) return false;
        int i = 0, k = 0, match = 0, starIdx = -1;
        while (i < s.length()) {

            // advancing both pointers
            if (k < p.length() && (p.charAt(k) == '?' || s.charAt(i) == p.charAt(k))) {
                i++;
                k++;
                // * found, only advancing pattern pointer
            } else if (k < p.length() && p.charAt(k) == '*') {
                starIdx = k;
                match = i;
                k++;
                // last pattern pointer was *, advancing string pointer
            } else if (starIdx != -1) {
                k = starIdx + 1;
                match++;
                i = match;
                //current pattern pointer is not star, last patter pointer was not *
                //characters do not match
            } else {
                return false;
            }
        }
        //check for remaining characters in pattern
        while (k < p.length() && p.charAt(k) == '*') {
            k++;
        }
        return k == p.length();
    }

    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        wm.isMatch("acdscd","*cd");
    }
}
