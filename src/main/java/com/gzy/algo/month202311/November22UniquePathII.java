package com.gzy.algo.month202311;

public class November22UniquePathII {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length - 1;
        int col = obstacleGrid[0].length - 1;
        if (obstacleGrid[row][col] == 1){
            return 0;
        }
        return process(obstacleGrid, 0, 0);
    }

    public int process(int[][] obstacleGrid, int row, int col){

        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1 ){
            return 1;
        }

        if (row == obstacleGrid.length){
            return 0;
        }
        if (col == obstacleGrid[0].length){
            return 0;
        }

        if (obstacleGrid[row][col] == 1){
            return 0;
        }



       return process(obstacleGrid, row + 1, col) + process(obstacleGrid, row, col + 1);


    }


    public int dp(int[][] obstacleGrid){
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col - 1] == 1){
            return 0;
        }
        int[][] dp = new int[row + 1][col + 1];
        dp[row - 1][col - 1] = 1;
        for (int i = row - 1; i >= 0; i--){
            for (int j = col - 1; j>= 0; j--){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
