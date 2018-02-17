package edu.helen.leetcode;

import java.util.*;

/**
 * https://discuss.leetcode.com/topic/65947/o-n-easy-to-understand-java-solution/2
 * Created by Helen on 10/22/2017.
 */
public class FrequencySort {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] frequency = new int[256];
        for (char c : s.toCharArray()) {
            frequency[c]++;
        }
        // Key of the tree represents how many times that character occurred in the String
        TreeMap<Integer, List<Character>> tree = new TreeMap<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                if (!tree.containsKey(frequency[i])) {
                    //if there are two characters which occur the same times like two,the key is the same?
                    //yes, but see next for loop
                    tree.put(frequency[i], new LinkedList<Character>());
                }
                tree.get(frequency[i]).add((char) i);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (tree.size() > 0) { // note: need to use while loop, since we need to get "key" by descending order
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            //for each character with the same occurrence, so it doesn't matter they have the same key
            for (Character ch : entry.getValue()) {
                builder.append(new String(new char[entry.getKey()]).replace('\0', ch)); //'\0' is initial default value for char type
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        FrequencySort sort = new FrequencySort();
        System.out.println(sort.frequencySort("abccbe"));

    }
}
