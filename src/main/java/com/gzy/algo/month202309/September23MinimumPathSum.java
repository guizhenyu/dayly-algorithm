package com.gzy.algo.month202309;

public class September23MinimumPathSum {

    public int minPathSum(int[][] grid){
        return process(grid, 0, 0);
    }

    public int process(int[][] grid, int m, int n){
        if (m == grid.length || n == grid[0].length){
            return Integer.MAX_VALUE;
        }

        if (m == grid.length - 1 && n == grid[0].length - 1){
            return grid[m][n];
        }
        int ans = grid[m][n];
        int p = Math.min(process(grid, m + 1, n), process(grid, m, n + 1));
        return ans + p;
    }


    public int dp(int[][] grid){
        int m = grid.length;
        int n = grid.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++){
            dp[m][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= m; i++){
            dp[i][n] = Integer.MAX_VALUE;
        }

        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--){
            dp[m - 1][i] = grid[m - 1][i] + Math.min(dp[m][i], dp[m - 1][i + 1]);
        }

        for (int i = m - 2; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}
