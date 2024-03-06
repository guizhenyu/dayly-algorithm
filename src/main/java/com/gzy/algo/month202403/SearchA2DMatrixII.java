package com.gzy.algo.month202403;

public class SearchA2DMatrixII {
    /**
     * Write an efficient algorithm that searches for a value target in an m * x integer matrix 'matrix'.
     * This matrix has the following properties;
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     *
     * @param matrix
     * @param target
     * @return
     */


    public int startR = 0;
    public int endR = 0;
    public int startC = 0;
    public int endC = 0;

    public boolean searchMatrix(int[][] matrix, int target){
        // use binary search to  solve the problem
        // we can use binary search form row.

        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int x = 0, y = cLen - 1;
        while (x < rLen && y >= 0){
            if (matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                x++;
            }else {
                y--;
            }
        }

        return false;
    }
}
