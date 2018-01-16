package edu.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/12473/java-solution-with-4-steps-explanations
 * <p>
 * https://discuss.leetcode.com/topic/12473/java-solution-with-4-steps-explanations/6
 * Created by Helen on 9/18/2017.
 */
public class String2Integer {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if (str == null || str.length() == 0) {
            return 0;
        }
        //2. Remove Spaces
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }
        //3. Handle signs
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        //4. Convert number and avoid overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            //Integer.MAX_VALUE = 2147483647 and Integer.MIN_VALUE = -2147483648, MAX/10=214748364, so digit >7
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return total * sign;

    }

    public static void main(String[] args) {
        String2Integer si = new String2Integer();
        System.out.println(si.myAtoi2("2147483648"));
    }

    public int myAtoi2(String str) {
        int index = 0, sign = 1, total = 0;
        if (str == null || str.length() == 0) return 0;
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }
        if (index < str.length() && str.charAt(index) == '-') {
            sign = -1;
            index++; // index++ can't be outside if/else since we only increment index if there is '+' or '-'
        } else if (index < str.length() && str.charAt(index) == '+') {
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            //total*10 is bigger than MAX already even without digit
            if (total > Integer.MAX_VALUE / 10 || total == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                total = digit + total * 10;
            }
            index++;
        }
        return total * sign;
    }

}
