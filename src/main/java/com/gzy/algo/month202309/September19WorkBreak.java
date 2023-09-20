package com.gzy.algo.month202309;

import com.sun.deploy.util.StringUtils;

import java.util.List;

public class September19WorkBreak {

    /**
     * Given a string s and dictionary of strings wordDict, return true if s can be segmented into a space-separated
     * sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict){
        return process(s, wordDict, 0);
    }

    private boolean process(String s, List<String> wordDict, int index) {
        if (index > s.length()){
            return false;
        }
        if (index == s.length()){
            return true;
        }
        Boolean ans = false;
        for (String str : wordDict){
            if (index + str.length() > s.length()){
                continue;
            }
            String sub = s.substring(index, index + str.length());

            if (sub.equals(str)){
                ans |= process(s, wordDict, index + str.length());
            }
        }
        return ans;
    }

    public boolean wordBreakDp(String s, List<String> wordDict){
        int end = s.length();
        boolean[] dp = new boolean[end + 1];
        dp[end] = true;

        int right = end - 1;
        while (right >= 0){
            for (String str : wordDict){
                if (right + str.length() > end){
                    continue;
                }
                String sub = s.substring(right, right + str.length());
                if (str.equals(sub)){
                    dp[right] |= dp[right + str.length()];
                }
            }

            right--;
        }


        return dp[0];
    }
}
