package edu.helen.leetcode;

        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;

/**
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


}
