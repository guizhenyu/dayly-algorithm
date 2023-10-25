package com.gzy.algo.month202310;

import java.util.*;

public class October23FindAnagrams {

    /**
     * Given two strings s and p, return any array of all the start indicates of p's anagrams in s.
     * You may return the answer in any order.
     *
     * An anagram is a word or phase formed by rearranging the letters form a different or phase, typically
     * using all the original letters exactly once.
     *
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagram(String s, String p){
        List<Integer> ans = new ArrayList<>();
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        int len = charS.length;
        int pLen = charP.length;
        if(len < pLen){
            return ans;
        }
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < pLen; i++){
            ++sArr[charS[i] - 'a'];
            ++pArr[charP[i] - 'a'];
        }


        if (Arrays.equals(sArr,pArr)){
            ans.add(0);
        }
        for (int i = 1; i <= len - pLen; i++){
            --sArr[charS[i - 1] - 'a'];
            ++sArr[charS[i + pLen - 1] - 'a'];
            if (Arrays.equals(sArr,pArr)){
                ans.add(i);
            }
        }

        return ans;
    }


    public static void main(String[] args) {

      String s = "cbaebabacd";
      String p = "abc";
      findAnagram(s, p);


    }
}
