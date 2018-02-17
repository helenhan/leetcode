package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.cnblogs.com/grandyang/p/6014408.html
 * https://discuss.leetcode.com/topic/64434/shortest-concise-java-o-n-sliding-window-solution
 * 首先统计字符串p的字符个数，然后用两个变量left和right表示滑动窗口的左右边界，用变量cnt表示字符串p中需要匹配的字符个数，
 * 然后开始循环，如果右边界的字符已经在哈希表中了，说明该字符在p中有出现，则cnt自减1，然后哈希表中该字符个数自减1，
 * 右边界自加1，如果此时cnt减为0了，说明p中的字符都匹配上了，那么将此时左边界加入结果res中。如果此时right和left的差为p的长度，
 * 说明此时应该去掉最左边的一个字符，我们看如果该字符在哈希表中的个数大于等于0，说明该字符是p中的字符
 * ，为啥呢，因为上面我们有让每个字符自减1，如果不是p中的字符，那么在哈希表中个数应该为0，自减1后就为-1，
 * 所以这样就知道该字符是否属于p，如果我们去掉了属于p的一个字符，cnt自增1，参见代码如下：
 * Created by Helen on 10/21/2017.
 */
public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        int[] map = new int[256];
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        int high = 0;
        int left = 0;
        int count = p.length();
        while (high < s.length()) {
            if (map[s.charAt(high++)]-- >= 1) {
                count--;
            }
            if (count == 0) {
                res.add(left);
            }
            if (high - left == p.length() && map[s.charAt(left++)]++ >= 0) { //because for char[left] has been minus one when moving high index
                count++;
            }
        }
        return res;
    }

    //time limit exceed
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return res;
        }
        int n = s.length();
        int m = p.length();
        for (int i = 0; i < n; i++) {
            if (i + m - 1 < n && isValid(s.substring(i, i + m), p)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isValid(String subStr, String p) {
        char[] sArray = subStr.toCharArray();
        char[] pArray = p.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(pArray);
        return Arrays.toString(sArray).equals(Arrays.toString(pArray));

    }


    public static void main(String[] args) {
        FindAllAnagramsInString fa = new FindAllAnagramsInString();
        System.out.println(Arrays.toString(fa.findAnagrams2("cbaebabacd", "abc").toArray()));
    }

}
