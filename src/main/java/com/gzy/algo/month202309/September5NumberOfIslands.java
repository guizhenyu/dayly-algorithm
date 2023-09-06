package com.gzy.algo.month202309;

public class September5NumberOfIslands {
    /**
     * Given an m x n 2D binary grid which represents a map of '1' (Land) and '0' (water),
     * return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
     * all four edges of the grid are all surrounded by water.
     *
     * @param grid
     * @return
     */
    public int numsIslands(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int col = 0;
        int row = 0;
        int ans = 0;
        while(col <= n - 1 && row <= m - 1){
            if (grid[row][col] == '1'){
                ans++;
                markGrid(grid, row, col);
            }
            if (col == n - 1){
                col = 0;
                row++;
            }else {
                col++;
            }
        }
        return ans;
    }

    private void markGrid(char[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length || i < 0 || j < 0){
            return;
        }
        if (grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        markGrid(grid, i, j + 1);
        markGrid(grid, i + 1, j);
        markGrid(grid, i, j - 1);
        markGrid(grid, i-  1, j);


    }

}
