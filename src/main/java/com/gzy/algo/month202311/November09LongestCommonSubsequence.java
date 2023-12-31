package com.gzy.algo.month202311;

public class November09LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        return process(text1, text2, 0, 0);
    }

    public int process(String text1, String text2, int index1, int index2){

        if (index1 == text1.length() || index2 == text2.length()){
            return 0;
        }

        char cha1 = text1.charAt(index1);
        char cha2 = text2.charAt(index2);
        int ans = Integer.MIN_VALUE;
        if (cha1 == cha2){
            ans = process(text1, text2, ++index1, ++index2) + 1;
        }else {
            ans = Math.max(ans, process(text1, text2, index1 + 1, index2));
            ans = Math.max(ans, process(text1, text2, index1, index2 + 1));
        }

        return ans;
    }

    public int process(String text1, String text2, int index1, int index2, int len){

        if (index1 == text1.length() || index2 == text2.length()){
            return len;
        }

        char cha1 = text1.charAt(index1);
        char cha2 = text2.charAt(index2);
        int ans = len;
        if (cha1 == cha2){
            ans = process(text1, text2, ++index1, ++index2, ++len);
        }

        ans = Math.max(ans, process(text1, text2, ++index1, index2, len));
        ans = Math.max(ans, process(text1, text2, index1, ++index2, len));

        return ans;
    }

    public int dp(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            if (chars1[i] == chars2[0]){
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++){
            if (chars2[i] == chars1[0]){
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(chars2[j] == chars1[i]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }

            }
        }



        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int m = text1.length();
        int n = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            if (chars1[i] == chars2[0]){
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++){
            if (chars2[i] == chars1[0]){
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){

                dp[i][j] = Math.max(dp[i - 1][j - 1],Math.max(dp[i - 1][j], dp[i][j - 1]));
                if(chars2[j] == chars1[i]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }

            }
        }

        int ans =  dp[m - 1][n - 1];

        System.out.println(ans);
    }

    public int dp1(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if (chars1[i] == chars2[j]){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

}
