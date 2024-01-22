package com.gzy.algo.month202401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class January21PalindromePartitioning {
    /**
     * Given a string s, partition s such that every substring of the  partition
     * is a palindrome. Return all possible palindrome partitioning of s.
     *
     *
     * @param s
     * @return
     */
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    boolean[][] dp;

    public List<List<String>> partition(String s){
        n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }
        //todo 这边采用动态规划到所有何可的palindrome index with start and end.
        //     初始化任意两个点之间都是true. 后面会比较任意 i, j 位置是否是相等，如果不相等
        //     就会设置为false.
        //     还有就是为什么这边，i 是从 n - 1开始，递减的遍历的。为什么不能从0开始呢？
        //     因为如果从0开始，我们已经知道dp的初始值全是true,  1 ~ j - 1之的情况我们还没遍历
        //     就无法确认dp[i][j]
        //     而我们从 n - 1 开始遍历，i = n - 1 直接跳过，因为j == n 不成立
        //     i = n - 2; j = n - 1; 此时 如果 s[i] == s[j] 就证明他们两是相等的，是回文，而 dp[i + 1][j - 1] => dp[n - 1][n - 2] == true
        //     i = n - 3; j = n - 2； dp[n - 3][n - 2] = (s[n - 3] == [n - 2]) && dp[n - 2][n - 3]
        //     i = n - 3; j = n - 1; dp[n - 3][n - 1] = (s[n - 3] == s[n - 1]) && dp[n - 2][n - 2]
        //     ........
        //     会发现，这样遍历会找到所以情况
        for (int i = n - 1; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int index) {
        if (index == n){
            ret.add(new ArrayList<>(ans));
        }
        // todo 这边采用的是回溯算法，因为要找到所有可能得结果子集，也就是返回所以得分割情况
        //      每种情况都建立的前面的分割情况是唯一的基础上的
        for (int i = index; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (dp[i][j]){
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }

    }




}
