package edu.helen.leetcode;

import java.util.*;

/**
 * Created by Helen on 9/21/2017.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<String>());
            }
            map.get(tmp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
