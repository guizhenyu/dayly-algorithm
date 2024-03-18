package com.gzy.algo.month202403;

import java.util.*;

public class RottingOranges {

    /**
     * You are given an m * n grid where each cell can  have one of three values:
     * 0 representing the empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange  becomes rotten.
     * Return the minimum num of minutes that must elapse until no cell has a fresh orange.If it is impossible,
     * return -1.
     *
     * @param grid
     * @return
     */


    public int orangesRotting(int[][] grid){
        // row num
        int R = grid.length;
        // column num
        int C = grid[0].length;

        // create a queue to contain the line num of the rotten orange
        Queue<Integer> queue = new LinkedList<>();
        // create a map to cache the depth of current rotten orange
        Map<Integer, Integer> map = new HashMap<>();

        // create two arrays to represent four direction move of the cell
        int[] rowM = {-1, 1, 0, 0};
        int[] colM = {0, 0, -1, 1};


        // iterate the grid
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (grid[r][c] == 2){
                    int address = r * C + c;
                    queue.add(address);
                    map.put(address, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()){
            Integer address = queue.remove();

            int r = address / C;
            int c = address % C;

            for (int m = 0; m < 4; m++){
                int rm = r + rowM[m];
                int cm = c + colM[m];
                if (rm >= 0 && rm < R && cm >= 0 && cm < C && grid[rm][cm] == 1){
                    grid[rm][cm] = 2;
                    int newAdd = rm * C + cm;
                    queue.add(newAdd);
                    map.put(newAdd, map.get(address) + 1);
                    ans = map.get(newAdd);
                }
            }
        }
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (grid[r][c] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }

}
