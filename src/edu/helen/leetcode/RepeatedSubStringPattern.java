package edu.helen.leetcode;

/**
 * 这道题给了我们一个字符串，问其是否能拆成n个重复的子串。
 * 那么既然能拆分成多个子串，那么每个子串的长度肯定不能大于原字符串长度的一半，那么我们可以从原字符串长度的一半遍历到1，
 * 如果当前长度能被总长度整除，说明可以分成若干个子字符串，我们将这些子字符串拼接起来看跟原字符串是否相等。 如果拆完了都不相等，返回false。
 * http://www.cnblogs.com/grandyang/p/6087347.html
 * Created by Helen on 10/22/2017.
 */
public class RepeatedSubStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) { //Note i>=1
            if (len % i == 0) {
                int m = len / i;
                String subStr = s.substring(0, i);
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    builder.append(subStr);

                }
                if (builder.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
