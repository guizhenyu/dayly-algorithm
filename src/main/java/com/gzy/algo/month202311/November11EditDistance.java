package com.gzy.algo.month202311;

public class November11EditDistance {


    public int minDistance(String word1, String word2) {


        return process(word1.toCharArray(), word2.toCharArray(), 0, 0);
    }

    private int process(char[] arr1, char[] arr2, int i1, int i2) {

       if (i1 == arr1.length){
           return arr2.length - i2;
       }

       if (i2 == arr2.length){
           return arr1.length - i1;
       }
       if (arr1[i1] == arr2[i2]){
           return process(arr1, arr2, i1 + 1, i2 + 1);
       }
       int ans1 = process(arr1, arr2, i1 + 1, i2) + 1;
       int ans2 =  process(arr1, arr2, i1 + 1, i2 + 1) + 1;
       int ans3 = process(arr1, arr2, i1, i2 + 1) + 1;

       return Math.min(ans1, Math.min(ans2, ans3));
    }

    public int dp(String word1, String word2){
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];


        for (int i = 0; i < n; i++){
            dp[m][i] = n - i;
        }

        for (int i = 0; i < m; i++){
            dp[i][n] = m - i;
        }

        for (int row = m - 1; row >= 0; row--){
            for (int col = n - 1; col >= 0; col--){
                if (word1.charAt(row) == word2.charAt(col)){
                    dp[row][col] = dp[row + 1][col + 1];
                }else {
                    dp[row][col] = Math.min(dp[row + 1][col], Math.min(dp[row + 1][col + 1], dp[row][col + 1])) + 1;
                }
            }
        }

        return dp[0][0];
    }
}
