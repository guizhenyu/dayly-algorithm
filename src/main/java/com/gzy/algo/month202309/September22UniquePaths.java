package com.gzy.algo.month202309;


/**
 * There is a robot on an m * n grid. The robot is initially located at the top-left corner(i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner(i.e., grid[m - 1][n - 1]).The robot can only move either down or
 * right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
 *
 */
public class September22UniquePaths {

    public int uniquePaths(int m, int n){



        return process(m, n, 1, 0) + process(m, n, 0, 1);

    }

    public int process(int m, int n, int row, int col){
        if (row >= m || col >= n){
            return 0;
        }
        if (row == m - 1 && col == n - 1){
            return 1;
        }

        int ans = 0;
        ans += process(m, n, row + 1, col);
        ans += process(m, n, row, col + 1);

        return ans;
    }


    public int dp(int m, int n){
        int[][] dp = new int[m + 1][n + 1];

        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                dp[i][j] +




                        = dp[i + 1][j] + dp[i][j + 1];

            }}

        return dp[0][0];
    }
}
