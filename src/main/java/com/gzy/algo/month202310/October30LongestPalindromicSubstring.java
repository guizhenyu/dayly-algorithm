package com.gzy.algo.month202310;

public class October30LongestPalindromicSubstring {

    /**
     * Given a String s,
     * return the longest palindromic substring in s.
     *
     * @param s
     * @return
     */
    public String longestPalindromicSubString(String s){
        if (s == null || s.length() <= 1){
            return s;
        }

        return manacher(s);
    }

    public String manacher(String s){

        char[] chars = populateStringWithHash(s);
        int n = chars.length;
        int[] pArr = new int[n];

        int max = 0;
        int maxIndex = -1;
        int R = -1;
        int C = -1;

        for (int i = 0; i < n; i++){
            int mirror_i = 2 * C - i;
            pArr[i] = R > i? Math.min(pArr[mirror_i], R - i) : 1;

            if (mirror_i >=0 && mirror_i - pArr[mirror_i] > 2 * C - R){
                continue;
            }

            while (i + pArr[i] < n && i - pArr[i] >= 0){
                if (chars[i + pArr[i]] == chars[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }

            if (i + pArr[i] > R){
                C = i;
                R = C + pArr[i];
            }

            if (max < pArr[i]){
                max = pArr[i];
                maxIndex = i;
            }
        }
        StringBuffer ans = new StringBuffer();
        int start = maxIndex - max + 1;
        int end = maxIndex + max - 1;
        for (int i = start; i <= end; ++i) {
            if (chars[i] != '#') {
                ans.append(chars[i]);
            }
        }
        return ans.toString();


    }


    public char[] populateStringWithHash(String s){

        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] ans  = new char[len * 2 + 1];

        int index = 0;
        for (int i = 0; i < ans.length; i++){

            if ((i & 1) == 0){
                ans[i] = '#';
            }else {
                ans[i] = chars[index++];
            }

        }

        return ans;

    }

}
