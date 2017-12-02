package edu.helen.leetcode;

/**
 *
 * http://www.cnblogs.com/grandyang/p/6493182.html
 * https://discuss.leetcode.com/topic/78603/straight-forward-java-dp-solution/2
 * Created by Helen on 11/9/2017.
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if(s==null||s.length()==0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
