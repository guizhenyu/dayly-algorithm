package com.gzy.algo.month202403;

import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     * @param s
     * @return
     */



    public List<List<String>> partition(String s){

    }

    public static void main(String[] args) {

        boolean[][] dp = new boolean[5][5];
        for (int i = 0; i < 5; i++){
            Arrays.fill(dp[i], true);
        }


        System.out.println(dp);

    }




}
