package com.gzy.algo.month202312;

public class December12Rotate2DMatrix {
    /**
     * You are given an n * n 2D matrix representing an image, rotate the image by 90 degrees(clockwise).
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     *
     *
     * @param matrix
     */

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int left = 0;
        int right = n - 1;
        int down = n - 1;
        int up = 0;

        while (left < right && up < down){
            int time = right - left;
            while (time > 0){
                int rightValue = leftToRight( matrix, up, left, right);
                int downValue = upToDown(matrix, right, up, down ,rightValue);
                int leftValue = rightToLeft(matrix, down, left, right, downValue);
                downToUp(matrix, left, up, down, leftValue);
                --time;
            }


            right--;
            down--;
            left++;
            up++;
        }



    }




    public int right(int row, int[][] matrix, int bound){
        int preValue = matrix[row][0];
        for (int i = 1; i < bound; i++){
            int tmp = matrix[row][i];
            matrix[row][i] = preValue;
            preValue = tmp;
        }
        return preValue;
    }

    public int leftToRight(int[][] matrix, int row, int start, int end){
        int preValue = matrix[row][start];
        for (int i = start + 1; i <= end; i++){
            int tmp = matrix[row][i];
            matrix[row][i] = preValue;
            preValue = tmp;
        }
        return preValue;

    }


    public int rightToLeft(int[][] matrix, int row, int start, int end, int preValue){
        for (int i = end - 1; i >= start; i--){
            int tmp = matrix[row][i];
            matrix[row][i] = preValue;
            preValue = tmp;
        }
        return preValue;

    }



    public int upToDown(int[][] matrix, int col, int start, int end, int preValue){

        for (int i = start + 1; i <= end; i++){
            int tmp = matrix[i][col];
            matrix[i][col] = preValue;
            preValue = tmp;
        }
        return preValue;

    }


    public void downToUp(int[][] matrix, int col, int start, int end, int preValue){

        for (int i = end - 1; i >= start; i--){
            int tmp = matrix[i][col];
            matrix[i][col] = preValue;
            preValue = tmp;
        }


    }

    public static void main(String[] args) {

        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        December12Rotate2DMatrix fn = new December12Rotate2DMatrix();

        fn.rotate(matrix);
        System.out.println(matrix);
    }
}
