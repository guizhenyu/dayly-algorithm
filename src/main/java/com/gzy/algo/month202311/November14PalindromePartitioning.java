package com.gzy.algo.month202311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class November14PalindromePartitioning {

    /**
     * 总共分为2部分
     * 第一部分： 动态规划找到所有符合回文的下标索引，就是通过二维数组表示
     * 第二部分:  回溯根据二维数组标识，把所有符合要求的回文找出来
     *
     * @param s
     * @return
     */

    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n ;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        for (int i= 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }

        for (int i = n - 1; i >= 0; i--){
            for (int j = i + 1; j < n; j++){

                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        dfs(s, 0);


        return ret;
    }

    private void dfs(String s, int i) {
        if (i == n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++){

            if(dp[i][j]){
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }


    }


}
