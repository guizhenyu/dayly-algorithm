package com.gzy.algo.month202401;

public class January31SearchA2DMatrixII {
    /**
     * Write an efficient algorithm that searches for a value target in an m * n integer
     * matrix.This matrix has the following properties:
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;

        int rStart = 0;
        int rEnd = m - 1;
        int cStart = 0;
        int cEnd = n - 1;

        while (rStart < rEnd && cStart < cEnd){
            int rMid = (rStart + rEnd) >> 1;
            int cMid = (cStart + cEnd) >> 1;
            int value = matrix[rMid][cMid];
            if (target == value){
                return true;
            }

            if (target < matrix[rMid][cMid]){
                rEnd = rMid;
                cEnd = cMid;
            }

            if (target > value){
                rStart = rMid;
                cStart = cMid;
            }

        }

        for (int r = rStart; r <= rEnd; r++){
            for (int c = cStart; c <= cEnd; c++){
                if (matrix[r][c] == target){
                    return false;
                }
            }
        }


        return false;

    }
}
