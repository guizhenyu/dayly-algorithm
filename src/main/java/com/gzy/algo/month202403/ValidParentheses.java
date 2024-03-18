package com.gzy.algo.month202403;

public class ValidParentheses {

    /**
     * Given a string s containing just the characters '(', ')', '{','}', '[',']', determine if the input string is valid.
     *
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char character = s.charAt(i);
            if (character == '(') {
                num1++;
            }
            if (character == ')') {
                if (num1 == 0) {
                    return false;
                } else {
                    num1--;
                }
            }
            if (character == '[') {
                num2++;
            }
            if (character == ']') {
                if (num2 == 0) {
                    return false;
                } else {
                    num2--;
                }
            }
            if (character == '{') {
                num3++;
            }
            if (character == '}') {
                if (num3 == 0) {
                    return false;
                } else {
                    num3--;
                }
            }
        }
        return num1 == 0 && num2 ==0 && num3 == 0;

    }
}
