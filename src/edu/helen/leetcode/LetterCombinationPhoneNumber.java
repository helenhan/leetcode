package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is a iterative solution. For each digit added, remove and copy every element in the queue and add the possible letter to each element,
 * then add the updated elements back into queue again. Repeat this procedure until all the digits are iterated.
 * 当已经获得digits[0:i-1]的所有letter combinations以后，加入digits[i]后新combinations为加入每个可能对应的字母加到之前的解集中。
 * time complexity O(n^2)
 * Created by Helen on 9/18/2017.
 */
public class LetterCombinationPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return list;
        }
        list.add("");//add empty string to make list.peek().length()==i to be true for the first digit
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0'; //minus '0' to convert digit from character to integer.
            while (list.peek().length() == i) { //length of combination equals index of digit which is needed to process right now.
                String str = list.remove();//for every combination, remove it and add new combination in result list after add new character
                for (int j = 0; j < mapping[digit].length(); j++) {
                    list.add(str + mapping[digit].charAt(j));
                }
            }
        }
        return list;
    }

    /**
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8109/My-recursive-solution-using-Java
     */
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        combination("",digits,0,res);
        return res;
    }

    private void combination(String prefix, String digits, int level,List<String> res) {
        if (level >= digits.length()) {
            res.add(prefix);
            return;
        } else {
            String str = KEYS[digits.charAt(level) - '0'];
            for (int i = 0; i < str.length(); i++) {
                combination(prefix+str.charAt(i),digits,level+1,res);
            }
        }

    }

    public static void main(String[] args) {
        LetterCombinationPhoneNumber lc = new LetterCombinationPhoneNumber();
        lc.letterCombinations2("23");
    }


}
