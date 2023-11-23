package com.gzy.algo.month202311;

public class November23DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s == "" || s.charAt(0) == '0'){
            return 0;
        }

        return process(s.toCharArray(), 0);
    }

    private int process(char[] chars, int index) {

        if (index > chars.length){
            return 0;
        }
        if (index == chars.length){
            return 1;
        }

        int digit = chars[index] - 48;

        if (digit == 0){
            return 0;
        }
        int ans = process(chars, index + 1);
        if (digit == 1){
            ans += process(chars, index + 2);
        }

        if (digit == 2){

            if (index < chars.length - 1 && chars[index + 1] - 48 <= 6){
                ans += process(chars, index + 2);
            }
        }
        return ans;
    }

    public int dp(char[] chars){
        int n = chars.length;
        int[] dp = new int[n + 2];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--){
            int digit = chars[i] - 48;
            if (digit == 0){
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1];
            if (digit == 1){
                dp[i] += dp[i + 2];
            }
            if (digit == 2){
                if (i < n - 1 && chars[i + 1] - 48 <= 6){
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {

        String s = "1";
        November23DecodeWays fc = new November23DecodeWays();
        System.out.println(fc.numDecodings(s));
    }
}
