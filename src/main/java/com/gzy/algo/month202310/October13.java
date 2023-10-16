package com.gzy.algo.month202310;

public class October13 {

    /**
     * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed)
     * parentheses substring.
     *
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s){
        int maxAns = 0;

        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i > 2? dp[i -2] : 0) + 2;
                }else if(i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + 2 + (i - dp[i -1] - 2 > 0? dp[i - dp[i - 1] - 2]: 0);

                }

                maxAns = Math.max(maxAns, dp[i]);
            }
        }

        return maxAns;

    }

    public int process(String s, int index, int ans){


    }
}
