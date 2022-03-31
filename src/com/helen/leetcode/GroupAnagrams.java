package com.helen.leetcode;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/group-anagrams/solution/
 * Complexity Analysis
 *
 Time Complexity: O(NK log (K) ), where N is the length of strs, and K is the maximum length of a string in strs.
 The outer loop has complexity O(N)as we iterate through each string. Then, we sort each string in O(K log K) time.
 Arrays.sort: time complexity is 0(K logK)

 Space Complexity: O(N*K), the total information content stored in ans.
 * Created by Helen on 9/21/2017.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars); // Note how to convert char array to String
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
