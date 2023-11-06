package com.gzy.algo.month202311;

import java.util.ArrayList;
import java.util.List;

public class November03SpiralMatrix {


    /**
     * given an n * m matrix, return all the elements in spiral order.
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = n - 1;
        int up = 0;
        int down = m - 1;
        List<Integer> ans = new ArrayList<>(m * n);
        while (l <= r && up <= down){
            for (int i = l; i <= r; i++){
                ans.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++){
                ans.add(matrix[i][r]);
            }
            if(l < r && up < down){
                for (int i = r - 1; i >= l; i--){
                    ans.add(matrix[down][i]);
                }
                for (int i = down - 1; i >up; i--){
                    ans.add(matrix[i][l]);
                }
            }

            l++;
            r--;
            up++;
            down--;
        }
        return ans;
    }


}
