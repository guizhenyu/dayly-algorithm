package com.gzy.algo.day20230828;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /**
     * The n-queens puzzle is the problem of placing n queues on an n x n chessboard such that no two queens attach each other.
     * <p>
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any other.
     * <p>
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and en empty
     * space, respectively.
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        int mask = 0;

        process(n, 0, ans, null, mask, 0, 0);
        return ans;
    }

    public static void process(int n, int index, List<List<String>> ans, List<String> p, int maskCol, int maskL, int maskR) {
        if (index == n) {
            ans.add(p);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (((1 << i) & (maskCol | maskL | maskR)) > 0) {
                continue;
            }

            maskCol |= (1 << i);
            maskL = maskL >> 1;

            maskR = maskR << 1;
            if (i > 0) {
                maskL |= (1 << (i - 1));
            }

            if (i < n - 1) {
                maskR |= (1 << (i + 1));
            }
            List<String> newP;
            if (p == null) {
                newP = new ArrayList();
            } else {
                newP = new ArrayList(p);
            }
            newP.add(packageChess(i, n));
            if (index == 1){
                System.out.println(1);
            }
            process(n, index + 1, ans, newP, maskCol, maskL, maskR);
        }

    }


    public static String packageChess(int index, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (i == index) {
                sb.append("Q");
            } else {
                sb.append(".");
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }


}
