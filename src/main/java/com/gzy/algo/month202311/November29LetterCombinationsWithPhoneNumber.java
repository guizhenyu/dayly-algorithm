package com.gzy.algo.month202311;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class November29LetterCombinationsWithPhoneNumber {

    public static final  String[] DIGIT_STRING = {"abc", "def","ghi","jkl","mno","pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return ans;
        }

        String[] strings = new String[digits.length()];
        for (int i = 0; i < strings.length; i++){
            strings[i] = DIGIT_STRING[digits.charAt(i) - '2'];
        }
        packageAns(strings, 0, "", ans);
        return ans;
    }

    private void packageAns(String[] strings, int index, String s, List<String> ans) {

        if (index == strings.length){
            ans.add(s);
            return;
        }

        String str = strings[index];

        for (char cha : str.toCharArray()){
            s = s + cha;
            packageAns(strings, index + 1, s, ans);
            s = s.substring(0, s.length() - 1);
        }
    }


}
