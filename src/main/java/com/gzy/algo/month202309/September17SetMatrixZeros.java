package com.gzy.algo.month202309;

public class September17SetMatrixZeros {
    /**
     * Given an m * n integer matrix, if an element is 0, set it's entire col or row to 0
     * You must do it in place.
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowFlags = new boolean[row];
        boolean[] colFlags = new boolean[col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){

                if (matrix[i][j] == 0){
                    rowFlags[i] = colFlags[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){

                if (rowFlags[i] || colFlags[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void setZeroes1(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;


        boolean col0 = false;

        for (int i = 0; i < row; i++){
            if (matrix[i][0] == 0){
                col0 = true;
            }
        }

        for (int i = 0; i < col; i++){
            if (matrix[0][i] == 0){
                matrix[0][0] = 0;
            }
        }

        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }


        for (int r = 1; r < row; r++){
            for(int c = 1; c < col; c++){
                if (matrix[0][c] == 0 || matrix[r][0] == 0){
                    matrix[r][c] = 0;
                }
            }
        }

        if (matrix[0][0] == 0){
            for (int c = 0; c < col; c++){
                matrix[0][c] = 0;
            }

        }
        if (col0){
            for (int r = 0; r < row; r++){
                matrix[r][0] = 0;
            }
        }
    }
}
