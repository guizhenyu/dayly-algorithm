package com.gzy.algo.month202403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     * @param s
     * @return
     */

    public boolean[][] dp;
    public int n;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    public List<List<String>> partition(String s){
        n = s.length();

        dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }

        for (int l = n - 1; l>= 0; l--){
            for (int r = l + 1; r < n; r++){

                dp[l][r] = s.charAt(l) == s.charAt(r);
                if(l + 1 <= r - 1){
                    dp[l][r] =  dp[l][r] && dp[l + 1][r - 1];
                }

            }
        }

        dfs(s, 0);

        return ret;

    }

    private void dfs(String s, int i) {

        if (i == n){
            ret.add(new ArrayList<>(ans));
        }

        for (int j = i; j < n; j++){
            if (dp[i][j]){
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }




}
