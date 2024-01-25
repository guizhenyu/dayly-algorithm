package com.gzy.algo.month202401;

public class January25SearchA2DMatrix {

    /**
     * You are given an m * n integer matrix with the following two properties
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the previous row.
     * Given an integer target, return true if target is in matrix or false otherwise.
     * You must write a solution in O(log (m * n)) time complexity.
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;
        
        int l = 0;
        int r = len - 1;

        while (l <= r){
            int mid = (l + r) >> 1;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return false;
    }


}
