package edu.helen.leetcode;

/**
 * Created by Helen on 10/26/2017.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int low = 0;
        int high = str.length() - 1;
        Character chLow, chHigh;
        while (low <= high) {
            chLow = str.charAt(low);
            chHigh = str.charAt(high);
            if (!Character.isLetterOrDigit(chLow)) {
                low++;
            } else if (!Character.isLetterOrDigit(chHigh)) {
                high--;
            } else {
                if (Character.toLowerCase(chLow) != Character.toLowerCase(chHigh)) {
                    return false;
                }
                low++;
                high--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("0P"));
    }
}
