package com.gzy.algo.month202401;

public class January18WordSearch {
    /**
     * Given an m x n grid of characters board and a string word, return true if word in the grid.
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically
     * neighboring. The same letter cell may not be used more than once.
     * Constraint:
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(check(board, chars, visited, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean check(char[][] board, char[] words, boolean[][] visited, int m, int n, int index){


        if (board[m][n] != words[index]){
            return false;
        }

        if (index == words.length - 1){

            // todo 这边为什么要提前判断是最后一个字母相等就结束了，因为如果m n 恰好到最后一个，而且相邻的点都已经走过了，下面的
            //      四个方向都不会走，那么就会直接返回false
            return true;
        }

        visited[m][n] = true;

        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        for (int[] direction : directions){

            int m1 = m + direction[0];
            int n1 = n + direction[1];

            if (m1 >= 0 && m1 < board.length && n1 >= 0 && n1 < board[0].length){
                if (visited[m1][n1]){
                    continue;
                }
                 //todo 刚开始还担心，后面的check递归会标记很多visited,却忘了回溯会将状态都恢复
                 if (check(board, words, visited, m1, n1, index + 1)){
                     return true;
                 }
            }

        }

        //Todo 回溯算法的核心就是要将之前的状态恢复
        visited[m][n] = false;

        return false;

    }




    public static void main(String[] args) {
        January18WordSearch func = new January18WordSearch();
        char[][] chars = {{'a'}};
        func.exist(chars, "a");
    }
}
