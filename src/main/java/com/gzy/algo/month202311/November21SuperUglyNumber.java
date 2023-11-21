package com.gzy.algo.month202311;

public class November21SuperUglyNumber {


    public int nthSuperUglyNumber(int n, int[] primes){
        int[] ans = new int[n];

        int  primeLength = primes.length;
        ans[0] = 1;
        int firstPrime = primes[0];
        int primeIndex = 0;
        int ansIndex = 1;
        for (int i = 1; i < n; i++){
             if (i == 1){
                 ans[i] = firstPrime;
//                 primeIndex++;
                 continue;
             }

             int nextPrime = primeIndex + 1 < primeLength? primes[primeIndex + 1]: Integer.MAX_VALUE;

             int nextAns = firstPrime * ans[ansIndex];
             if (nextPrime > nextAns){
                 ans[i] = nextAns;
                 ansIndex++;
             }else {
                 primeIndex++;
                 ans[i] = nextPrime;
             }

        }

        return ans[n - 1];
    }
}
