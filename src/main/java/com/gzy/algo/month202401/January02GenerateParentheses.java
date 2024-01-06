package com.gzy.algo.month202401;

import java.util.ArrayList;
import java.util.List;

public class January02GenerateParentheses {

    /**
     * give n pairs of parentheses,
     * write a function to generate all combinations of well-formed parentheses.
     *
     *
     * @return
     */
    public List<String> generateParentheses(int n){

        List<String> ans = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        process(n * 2,  0, 0, sb, ans);

        return ans;
    }

    private void process(int len, int index, int sum, StringBuffer sb, List<String> ans) {

        if (index == len && sum == 0){
            ans.add(sb.toString());
        }

        if (index == len){
            return;
        }
        if (sum < 0){
            return;
        }
        process(len, index + 1, sum - 1, sb.append(")"), ans);
        sb.deleteCharAt(sb.length() - 1);

        process(len, index + 1, sum + 1, sb.append("("), ans);
        sb.deleteCharAt(sb.length() - 1);

    }
}
