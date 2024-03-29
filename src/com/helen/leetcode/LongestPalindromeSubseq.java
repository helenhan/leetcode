package com.helen.leetcode;

/**
 * http://www.cnblogs.com/grandyang/p/6493182.html
 * https://discuss.leetcode.com/topic/78603/straight-forward-java-dp-solution/2
 * <p>
 * 这道题给了我们一个字符串，让我们求最大的回文子序列，子序列和子字符串不同，不需要连续。而关于回文串的题之前也做了不少，
 * 处理方法上就是老老实实的两两比较吧。像这种有关极值的问题，最应该优先考虑的就是贪婪算法和动态规划，
 * 这道题显然使用DP更加合适。我们建立一个二维的DP数组，其中dp[i][j]表示[i,j]区间内的字符串的最长回文子序列，
 * 那么对于递推公式我们分析一下，如果s[i]==s[j]，那么i和j就可以增加2个回文串的长度，我们知道中间dp[i + 1][j - 1]的值，
 * 那么其加上2就是dp[i][j]的值。如果s[i] != s[j]，那么我们可以去掉i或j其中的一个字符，然后比较两种情况下所剩的字符串谁dp值大，就赋给dp[i][j]，那么递推公式如下：
 * <p>
 * /  dp[i + 1][j - 1] + 2                       if (s[i] == s[j])
 * <p>
 * dp[i][j] =
 * <p>
 * \  max(dp[i + 1][j], dp[i][j - 1])        if (s[i] != s[j])
 * <p>
 * Created by Helen on 11/9/2017.
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) { //the first j(n-1+1) is never executed, because for loop is like (initial, condition, statement, increment)
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq lps = new LongestPalindromeSubseq();
        lps.longestPalindromeSubseq("bbbab");
    }
}
