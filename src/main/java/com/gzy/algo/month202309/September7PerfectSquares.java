package com.gzy.algo.month202309;

public class September7PerfectSquares {


    /**
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     *
     * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
     * For example, 1, 4, 9 and 16 are perfect squares while 3 and 11 are not.
     *
     * @param n
     * @return
     */
    public int numSquares(int n){
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, 1 + dp[i - j * j]);
            }

            dp[i] = min;
        }
        return dp[n];
    }

    /**
     * Depends on Lagrange's Four-Square Theorem
     *
     *
     * @param n
     * @return
     */
    public int numSquaresWithMathematics(int n){

        if(isSquare(n)){
            return 1;
        }

        if (isAnswer4(n)){
            return 4;
        }


        for (int i = 1; i * i< n; i++){

            if (isSquare(n - i * i)){
                return 2;
            }


        }

        return 3;
    }

    public boolean isSquare(int n){
        int x = (int)Math.sqrt(n);
        return x * x == n;
    }

    public boolean isAnswer4(int n){
        while (n % 4 == 0){
            n /= 4;
        }

        return n % 8 == 7;
    }





}
