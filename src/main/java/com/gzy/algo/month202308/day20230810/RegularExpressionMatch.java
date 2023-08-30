package com.gzy.algo.month202308.day20230810;

public class RegularExpressionMatch {

    /**
     *  Regular Expression Matching
     *
     *  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     *
     *  给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * Constraints:
     *
     * 1 <= s.length <= 20
     * 1 <= p.length <= 20
     * s contains only lowercase English letters.
     * p contains only lowercase English letters, '.', and '*'.
     * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
     *
     * 提示：
     *
     * 1 <= s.length <= 20
     * 1 <= p.length <= 20
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        // fist step  violent recursion
        return violentRecursion(s, p, s.length(), p.length());
    }

    /**
     * violent recursion
     *
     * @param s
     * @param p
     * @param sIndex
     * @param pIndex
     * @return
     */
    private  boolean violentRecursion(String s, String p, int sIndex, int pIndex) {

        // the matching is over without false
        if (sIndex == 0 && pIndex == 0){
            return true;
        }

        if (pIndex == 0){
            return false;
        }

        boolean ans = false;
        if (p.charAt(pIndex - 1) == '*'){
            // represent zero pre character
            ans = violentRecursion(s, p, sIndex, pIndex - 2);

            if (matchs(s, p, sIndex, pIndex - 1)){
                ans = ans || violentRecursion(s, p, sIndex - 1, pIndex);
            }
        }else {
            if (matchs(s, p, sIndex, pIndex)){
                ans =  violentRecursion(s, p, sIndex - 1, pIndex - 1);
            }
        }



        return ans;
    }

    public static void main(String[] args) {
        RegularExpressionMatch regularExpressionMatch = new RegularExpressionMatch();

        System.out.println(regularExpressionMatch.isMatch("aa", "a*"));
    }


    public boolean isMatchDp(String s, String p){
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        // '*'
        for(int i = 0; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (p.charAt(j - 1) == '*'){
                    //'*' Matches zero or more of the preceding element.
                    // Tt is guaranteed for each appearance of the character '*', there will be a previous character to match.
                    // so j - 2 >= 0
                    // first '*' represent zero preceding element
                    dp[i][j] = dp[i][j - 2];

                    // '*' represent one  preceding element at least

                    if (matchs(s, p, i, j - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else{
                    if (matchs(s, p, i, j)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[n][m];
    }

    public boolean matchs(String s, String p, int i, int j){
        if (i == 0){
            return false;
        }

        if (p.charAt(j - 1) == '.'){
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
